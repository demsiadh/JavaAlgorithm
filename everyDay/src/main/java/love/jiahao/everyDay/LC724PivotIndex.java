package love.jiahao.everyDay;

import java.util.Arrays;

/**
 * <big>力扣 724. 寻找数组的中心索引</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/8 上午11:23
 */
public class LC724PivotIndex {

    /**
     * 暴力解法
     * <p>遍历数组的每个下标，遍历数组的每个元素，计算左边和右边的和，如果相等，则返回当前下标。</p>
     *
     * @param nums 数组
     * @return 中心索引
     */
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int left = 0;
        for (int i = 0; i < length; i++) {
            int right = 0;
            for (int j = i + 1; j < length; j++) {
                right += nums[j];
            }
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    /**
     * 前缀和
     * <p>由于需要下标两边都相等，所以可以根据左边的和 * 2 + 当前下标的值 = 数组的和</p>
     * <p>来找到所需要的最左边的中心索引</p>
     *
     * @param nums 数组
     * @return 中心索引
     */
    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
