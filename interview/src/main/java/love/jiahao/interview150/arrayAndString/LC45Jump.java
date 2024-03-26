package love.jiahao.interview150.arrayAndString;

/**
 * <big>跳跃游戏二 - 到达最后一个位置的最小步数</big>
 * <p>求得每个点能到的最远位置，当下次下标到上次最远位置后，步数加一，直到循环结束</p>
 *
 * @author 13684
 * @date 2024/3/15
 */
public class LC45Jump {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jump(nums1));

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jump(nums2));

    }

    public static int jump(int[] nums) {
        int length = nums.length - 1; // 数组小标最大值（用这个做循环是因为最后一位元素不影响步数）
        int maxDistance = 0; // 最远到达的距离
        int end = 0; // 当前到达的最远距离 下一次到此时需要步数加一
        int step = 0; // 步数
        for (int i = 0; i < length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == end) {
                step++;
                end = maxDistance;
            }
        }
        return step;
    }
}
