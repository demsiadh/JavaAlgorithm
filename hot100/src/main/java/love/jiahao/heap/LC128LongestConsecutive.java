package love.jiahao.heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/23 下午7:49
 */
public class LC128LongestConsecutive {
    /**
     * 首先用set收集数组内容
     * 遍历数组，如果set中不包含当前元素减一，则从当前元素开始，遍历set，如果包含，则加一，直到遍历结束，取最大值
     *
     * @param nums 输入数组
     * @return /
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer i : set) {
            // 这里采用从最小值往最大值靠拢，其实都一样，迟早会遍历到最值，所以只用找一次
            if (!set.contains(i - 1)){
                int big = 1;
                while (set.contains(i + big)){
                    big++;
                }
                max = Math.max(max, big);
            }
        }
        return max;
    }
}
