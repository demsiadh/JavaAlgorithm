package love.jiahao.hash.lc;

import java.util.HashMap;

/**
 * <big>两数之和</big>
 *
 * @author 13684
 * @date 2024/3/21
 */
public class LC01TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
