package love.jiahao.interview150.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * <big>最长连续序列</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC128LongestConsecutive {

    /*
        首先将数组中元素使用set进行去重
        随后对set进行遍历，如果当前数(n)不存在 n - 1
        则每次循环遍历到是否有 n + 1  每次n++ 并且 长度加一
        最终将当前长度和最大长度取最大值
     */
    public int longestConsecutive(int[] nums) {     // 81 19
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                max = Math.max(max, currentStreak);
            }
        }
        return max;
    }
}
