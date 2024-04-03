package love.jiahao.interview150.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>两数之和</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC01TwoSum {
    /*
        两数之和，把遍历过的数值作为key，索引作为value
        如果碰到map中有目标值减去当前值的结果
        即为找到了
     */
    public int[] twoSum(int[] nums, int target) {   // 99 55
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
