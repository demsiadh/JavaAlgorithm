package love.jiahao.interview150.arrayAndString;

/**
 * <big>查找多数元素（出现次数多于一半）</big>
 * <p>只需将数组排序后，中间元素便为众数</p>
 *
 * @author 13684
 * @date 2024/3/13
 */
public class LC169MajorityElement {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        bubble(nums, length - 1);
        return nums[length / 2];
    }

    // 排序 冒泡排序
    public static void bubble(int[] nums, int right) {
        if (right == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                x = i;
            }
        }
        bubble(nums, x);
    }
}
