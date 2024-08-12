package love.jiahao.hot;

/**
 * <big>打家劫舍</big>
 * <p></p>
 *
 * @author 游星
 * @data 2024/8/12 上午10:39
 */
public class LC198Rob {
    /**
     * 推出规律
     * 假如只有一家，那就是偷获取的金额最高 nums[0]
     * 如果有两家，就是偷取金额最高的一家 Math.max(nums[0], nums[1])
     * 到第三家，规律来了，这个时候就需要选择偷还是不偷，这时的最高金额是 Math.max(num[0] + nums[2], nums[1])
     * 以此类推，直到最后一家，金额最大值就是 dp[length - 1]
     *
     * @param nums 整数数组
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
