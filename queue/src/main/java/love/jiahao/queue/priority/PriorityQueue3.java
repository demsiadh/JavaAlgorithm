package love.jiahao.queue.priority;

import love.jiahao.queue.Queue;

/**
 * <big>大顶堆实现优先级队列</big>
 * <p>根节点在0索引位置</p>
 *
 * @author 13684
 * @date 2024/2/27
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    /**
     * <p>先插入到最后面，然后与父节点的优先级进行比较，如果优先级较高则让原来的父节点跑到下面</p>
     * <p>保持大顶堆的特性</p>
     * @param value 待插入值
     * @return 插入结果
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        insert(value);
        return true;
    }

    private void insert(E value) {
        // 子节点索引位置
        int child = size++;
        // 父节点
        int parent = (child - 1) / 2;
        // 判断新插入的值的优先级和原来的父节点的优先级哪个大
        while (child > 0 && value.priority() > array[parent].priority()) {
            // 如果大于父节点的优先级则交换位置
            array[child] = array[parent];
            // 新的子节点和父节点
            child = parent;
            parent = (child - 1) / 2;
        }
        // 找到位置时直接插入
        array[child] = value;
    }

    /**
     * <p>首先交换堆顶和堆底元素。size--</p>
     * <p>将交换上去的元素与左右孩子对比，与较大的交换</p>
     * <p>直到父元素大于孩子或者没孩子</p>
     *
     * @return 取出结果
     */
    @Override
    @SuppressWarnings("all")
    public E poll() {
        if (isEmpty()) return null;
        E result = (E) array[0];
        array[0] = array[--size];
        array[size] = null;
        int parent = 0;
        int leftChild = 1;
        int rightChild = 2;
        int max = parent; // 假设父节点优先级最高
        while (leftChild <= size - 1) {
            if (array[leftChild].priority() > array[max].priority()) {
                max = leftChild;
            }
            if (rightChild <= size - 1 && array[rightChild].priority() > array[max].priority()) {
                max = rightChild;
            }

            if (max != parent) {
                E e = (E) array[max];
                array[max] = array[parent];
                array[parent] = e;
            } else {
                break;
            }
            parent = max;
            leftChild = parent * 2 + 1;
            rightChild = leftChild + 1;
        }

        return result;
    }

    @Override
    @SuppressWarnings("all")
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
