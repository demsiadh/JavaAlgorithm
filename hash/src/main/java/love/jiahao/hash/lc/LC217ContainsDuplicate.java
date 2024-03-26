package love.jiahao.hash.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <big>p判断数组中是否有重复的元素</big>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) { // 97 26
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) { // 98 75
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);
        Integer i = 1;
        for (int num : nums) {
            if (map.put(num, i) != null) {
                return true;
            }
        }
        return false;
    }
}
