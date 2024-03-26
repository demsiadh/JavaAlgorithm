package love.jiahao.heap.lc;

/**
 * <big>力扣703题数据流中的第k大元素</big>
 * <p>注意是数据流不是数组，是变化的</p>
 *
 * @author 13684
 * @date 2024/2/29
 */
public class LC703KthLargest {
    private final MinHeap minHeap;

    public LC703KthLargest(int k, int[] nums) {
        minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.isFull()){
            if (val > minHeap.peek()) {
                minHeap.replace(val);
            }
        }else minHeap.offer(val);
        return minHeap.peek();
    }


    static class MinHeap{
        int[] array;
        int size;
        public MinHeap(int capacity) {
            array = new int[capacity];
        }

        public void offer(int offered) {
            array[size] = offered;
            up(size);
            size++;
        }

        private void up(int index) {
            int max = index;
            int parent = (index - 1) / 2;
            if (parent >= 0 && array[parent] > array[index]) {
                max = parent;
                swap(index, max);
                up(max);
            }
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void replace(int replaced) {
            array[0] = replaced;
            down(0);

        }
        private void down(int index) {
            int min = index;
            int left = index * 2 + 1;
            int right = left + 1;
            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != index) {
                swap(min, index);
                down(min);
            }
        }
        public int peek() {
            return array[0];
        }
        public boolean isFull() {
            return size == array.length;
        }
    }
}
