package love.jiahao.queue.priority;

import love.jiahao.queue.Queue;

import java.util.Properties;

/**
 * <big>无序数组实现优先级队列</big>
 * <p>优先级队列就是取出元素时，根据优先级进行取出</p>
 * <p>这里使用无序数组，添加元素时直接添加到尾部，取出时将后方元素迁移</p>
 * @author 13684
 * @date 2024/2/27
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    // 因为所有的元素必须时Priority的子类型所以这里用这个类型
    // 上面写extends并不是继承只是一种写法表示子类型
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity){
        array = new Priority[capacity];
        size = 0;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[size++] = value;
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public E poll() {
        if (isEmpty()) return null;
        int max = selectMax();
        E result = (E) array[max];
        remove(max);
        return result;
    }

    /**
     * 移除索引位置元素
     * @param index 索引
     */
    private void remove(int index) {
        if (index < size - 1) {
            // 2.如果为其他元素则需要移动
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }

        // 1.如果删除的为最后一个元素，不需要移动其他元素直接进行删除
        array[--size] = null;

    }

    @Override
    @SuppressWarnings("all")
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[selectMax()];
    }

    /**
     * 返回优先级最高元素的索引值
     * @return 索引值
     */
    private int selectMax() {
        // 优先级最高的索引值，默认从0索引开始
        int result = 0;
        // 遍历数组，如果当前索引值优先级大于result的索引值优先级就替换result的值
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[result].priority()) {
                result = i;
            }
        }
        return result;
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
