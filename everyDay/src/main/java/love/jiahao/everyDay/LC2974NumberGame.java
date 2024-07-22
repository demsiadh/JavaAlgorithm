package love.jiahao.everyDay;

/**
 * <big>力扣2974题 最小数字游戏</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/22 下午2:21
 */
public class LC2974NumberGame {
    /**
     * 思路：冒泡排序，然后双双交换
     * 根据题目特性可知每次取出最小的两个，但是他们顺序刚好相反
     * 所以不难得出直接升序排序，然后两两交换
     *
     * @param nums 原始数组
     * @return 处理后的数组
     */
    public int[] numberGame(int[] nums) {
        int length = nums.length;
        bubbleSort(nums);
        for (int i = 1; i < length; i += 2) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    private void bubbleSort(int[] nums) {
        int length = nums.length;
        int right = length - 1;
        while (right > 0) {
            int rightNext = 0;
            for (int i = 0; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    rightNext = i;
                }
            }
            right = rightNext;
        }
    }
}
