package love.jiahao.interview150.arrayAndString;

/**
 * <big>跳跃游戏 - 是否能到达最后一个位置</big>
 * <p>记录最远能到达的位置，如果最远位置能到最后一位元素就返回真</p>
 * <p>如果最远距离还到不了下一个元素就打破循环</p>
 *
 * @author 13684
 * @date 2024/3/15
 */
public class LC55CanJump {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));

        int[] nums3 = {1, 0, 2, 3, 4};
        System.out.println(canJump(nums3));
    }

    public static boolean canJump(int[] nums) {
        int maxDistance = 0;    // 最远距离 用来记录最远距离
        int tempDistance;       // 当前能移动到的最远距离 = 当前位置下标 + 当前位置数字大小
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            tempDistance = nums[i] + i;
            if (tempDistance > maxDistance) {
                maxDistance = tempDistance;
            }
            if (maxDistance < i + 1) {
                break;
            }
        }

        return maxDistance >= length;
    }
}
