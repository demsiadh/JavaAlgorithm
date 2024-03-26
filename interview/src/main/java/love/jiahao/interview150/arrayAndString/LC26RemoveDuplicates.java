package love.jiahao.interview150.arrayAndString;

import java.util.Arrays;

/**
 * <big>删除有序数组重复项</big>
 *
 * @author 13684
 * @date 2024/3/13
 */
public class LC26RemoveDuplicates {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 3, 3, 4, 4, 5};
        System.out.println(removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }

    /**
     * <h2>快慢指针法</h2>
     * <p>到而指针数字不相等时添加元素</p>
     *
     * @param nums 数组
     * @return 不重复数组的长度
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) return length;

        int slow = 1;
        int quick = 1;
        while (quick < length) {
            if (nums[slow - 1] != nums[quick]) {
                nums[slow] = nums[quick];
                slow++;
            }
            quick++;
        }
        return slow;
    }

}
