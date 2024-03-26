package love.jiahao.heap;

import java.util.Arrays;

/**
 * <big>小顶堆</big>
 * @author 13684
 * @date 2024/2/28
 */
public class MinHeap implements Heap {
    int[] array;
    int size;

    public static void main(String[] args) {
//        MinHeap minHeap = new MinHeap(new int[]{2, 5, 7, 6, 4, 8});
//        System.out.println(minHeap);
        MinHeap minHeap = new MinHeap(10);
        minHeap.offer(3);
        minHeap.offer(2);
        System.out.println(minHeap);
    }
    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.array = array;
        size = array.length;
        heapify();
    }

    /**
     * <p>建堆算法</p>
     * <p>找到最后一个非叶子节点（有孩子的节点）</p>
     * <p>从后向前，对每个节点执行下潜</p>
     */
    @Override
    public void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * <p>下潜方法</p>
     *
     * @param index 需要下潜的索引
     */
    private void down(int index) {
        int left = index * 2 + 1;
        int right = left + 1;
        int max = index;
        // 循环实现
//        while (left < size) {
//            if (array[left] > array[max]) {
//                max = left;
//            }
//            if (right < size && array[right] > array[max]) {
//                max = right;
//            }
//            if (max != index) {
//                swap(index, max);
//                index = max;
//                left = max * 2 + 1;
//                right = left + 1;
//            } else break;
//        }

        if (left < size && array[left] < array[max]) {
            max = left;
        }
        if (right < size && array[right] < array[max]) {
            max = right;
        }
        if (max != index) {
            swap(index, max);
            // 继续下潜
            down(max);
        }
    }

    /**
     * 交换两个索引位置处的元素
     *
     * @param i 元素1
     * @param j 元素2
     */
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 移除堆顶元素
     *
     * @return 移除的元素
     */
    @Override
    public int poll() {
        if (isEmpty()) throw new RuntimeException("堆为空!");
        int result = array[0];
        swap(0, --size);
        down(0);
        return result;
    }

    @Override
    public int poll(int index) {
        if (isEmpty() || index > size - 1) throw new RuntimeException("索引位置元素不存在!");
        int result = array[index];
        swap(index, --size);
        down(index);
        return result;
    }

    @Override
    public int peek() {
        if (isEmpty()) throw new RuntimeException("堆为空!");
        return array[0];
    }

    @Override
    public void replace(int replaced) {
        if (isEmpty()) size++;
        array[0] = replaced;
        down(0);
    }

    @Override
    public boolean offer(int offered) {
        if (isFull()) return false;
        array[size] = offered;
        up(size);
        size++;
        return true;
    }

    /**
     * <P>上浮</P>
     *
     * @param offered 需要上浮元素的索引
     */
    private void up(int offered) {
        // 假设当前节点为最小的
        int min = offered;
        int parent = (offered - 1) / 2;
        if (parent >= 0 && array[parent] > array[min]) {
            min = parent;
            swap(min, offered);
            up(min);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }


}
