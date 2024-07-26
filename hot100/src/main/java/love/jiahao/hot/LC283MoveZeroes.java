package love.jiahao.hot;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/23 下午8:45
 */
public class LC283MoveZeroes {
    /**
     * 参考冒泡排序思想，将0往后移
     * 执行时间较长
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int right = length - 1;
        while (right >= 0) {
            int x = -1;
            for (int i = 0; i < right; i++) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[right];
                    nums[right] = temp;
                    x = i;
                }
            }
            right = x;
        }
    }

    /**
     * 记录非0的数字，并排到最前面，从最后位置往后补0
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int first = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[first++] = nums[i];
            }
        }
        for (int i = first; i < length; i++) {
            nums[i + 1] = 0;
        }
    }
}
