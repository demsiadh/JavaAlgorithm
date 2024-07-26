package love.jiahao.hot;

import java.util.*;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/25 上午10:34
 */
public class LC15ThreeSum {
    /**
     * 这里采用了笨方法，借鉴两数之和的思路
     * 但是嵌套了两层循环，效率还是不高的
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先把数组的值存起来
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-nums[i] - nums[j]) && map.get(-nums[i] - nums[j]) > j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    Collections.sort(list);
                    result.add(list);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
