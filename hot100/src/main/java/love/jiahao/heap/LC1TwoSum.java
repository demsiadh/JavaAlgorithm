package love.jiahao.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>力扣1 - 两数之和</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/22 下午5:05
 */
public class LC1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
