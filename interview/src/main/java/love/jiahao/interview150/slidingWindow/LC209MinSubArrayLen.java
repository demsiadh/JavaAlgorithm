package love.jiahao.interview150.slidingWindow;

/**
 * <big>长度最小的子数组</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC209MinSubArrayLen {

    /*
        1. 利用滑动窗口思想，设置首尾指针
        2. 当和不超过target时end右移
        3. 超过时start右移
        4. 每次超过时记录当前长度 = end - start + 1(记录长度前end不能右移)
     */
    public int minSubArrayLen(int target, int[] nums) { // 99 54
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }

        return min == Integer.MAX_VALUE? 0: min;
    }
}
