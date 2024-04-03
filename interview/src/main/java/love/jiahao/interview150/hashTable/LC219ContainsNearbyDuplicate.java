package love.jiahao.interview150.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>存在重复元素2</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC219ContainsNearbyDuplicate {
    /*
        使用map集合存储每次的值和索引，碰到相同的值就将索引进行相减
        如果小于等于k则返回true，
        如果不是则把当前值和索引put上去，并进行下一次循环
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {     // 84 45
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
