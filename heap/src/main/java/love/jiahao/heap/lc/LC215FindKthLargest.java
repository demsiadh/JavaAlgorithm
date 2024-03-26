package love.jiahao.heap.lc;

import love.jiahao.heap.MinHeap;

/**
 * <big>力扣215题，数组中第k个最大元素</big>
 * @author 13684
 * @date 2024/2/28
 */
public class LC215FindKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
    /**
     * <h2>小顶堆实现</h2>
     * <p>解题思路</p>
     * <li>往小顶堆添加前k个元素</li>
     * <li>剩余元素如果小于堆顶元素，则跳过，大于则替换堆顶</li>
     * <li>这样小顶堆堆顶始终保持的是第k大的元素</li>
     * @param nums 数组
     * @param k 第k大元素
     * @return 结果
     */
    public static int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
