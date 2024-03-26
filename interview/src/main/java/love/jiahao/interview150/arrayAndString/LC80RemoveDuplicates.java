package love.jiahao.interview150.arrayAndString;

/**
 * <big>删除有序数组重复项（最多有两个重复的）</big>
 * <p>快慢指针，参考26题只需将判断变为前面的前面的元素，即可解决</p>
 *
 * @author 13684
 * @date 2024/3/13
 */
public class LC80RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;
        int slow = 2;
        int quick = 2;
        while (quick < length) {
            if (nums[slow - 2] != nums[quick]) {
                nums[slow] = nums[quick];
                slow++;
            }

            quick++;
        }
        return slow;
    }
}
