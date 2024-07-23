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
    /**
     * 创建一个map集合存入已经遍历过的数组元素和下标
     * 可以通过map中的key是否包含和现在元素值相加是否等于目标值来判断是否找到答案
     * @param nums 数组
     * @param target 目标值
     * @return 下标
     */
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
