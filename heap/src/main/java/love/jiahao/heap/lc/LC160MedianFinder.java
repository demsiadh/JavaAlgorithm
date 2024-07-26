package love.jiahao.heap.lc;

import java.util.Arrays;

/**
 * <big>力扣160题寻找数据流的中位数</big>
 * <p>解题思路</p>
 * <li>用一个大顶堆存放较小值，小顶堆存放较大值</li>
 * <li>数量相等则相加/2为中位数，不相等则大顶堆的最大值为中位数</li>
 *
 * @author 13684
 * @date 2024/2/29
 */
public class LC160MedianFinder {
    private final Heap left;
    private final Heap right;

    public LC160MedianFinder() {
        left = new Heap(8, true);
        right = new Heap(8, false);
    }

    public void addNum(int num) {
        if (left.getSize() == right.getSize()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        } else return left.peek();
    }

    static class Heap {
        int[] array;
        private int size;
        private final boolean max;

        public Heap(int capacity, boolean max) {
            array = new int[capacity];
            this.max = max;
        }

        public boolean replace(int replaced) {
            if (isEmpty()) return offer(replaced);
            array[0] = replaced;
            down(0);
            return true;
        }

        public boolean offer(int offered) {
            if (isFull()) grow();
            array[size] = offered;
            up(size++);
            return true;
        }

        private void grow() {
            int capacity = size + (size >> 1);
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        public int poll() {
            if (isEmpty()) return -1;
            int result = array[0];
            swap(0, size - 1);
            array[size - 1] = 0;
            size--;
            down(0);
            return result;
        }

        public int peek() {
            if (isEmpty()) return 0;
            return array[0];
        }

        private void up(int index) {
            int temp = index;
            int parent = (index - 1) / 2;
            if (max ? array[temp] > array[parent] : array[temp] < array[parent]) {
                temp = parent;
            }

            if (temp != index) {
                swap(temp, index);
                up(temp);
            }

        }

        private void down(int index) {
            int temp = index;
            int left = index * 2 + 1;
            int right = left + 1;

            if (left < size && (max ? array[left] > array[temp] : array[left] < array[temp])) {
                temp = left;
            }
            if (right < size && (max ? array[right] > array[temp] : array[right] < array[temp])) {
                temp = right;
            }
            if (temp != index) {
                swap(temp, index);
                down(temp);
            }

        }

        public void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public boolean isFull() {
            return size == array.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }

    public static void main(String[] args) {
        LC160MedianFinder finder = new LC160MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
