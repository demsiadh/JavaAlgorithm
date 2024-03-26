package love.jiahao.hash.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <big>无重复的最长子串</big>
 *
 * @author 13684
 * @date 2024/3/21
 */
public class LC03LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int max = 0;
        int begin = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<>();
        while(end < length) {
            if (set.contains(s.charAt(end))) {
                max = Math.max(set.size(), max);
                set.clear();
                end = ++begin;
            }else {
                set.add(s.charAt(end));
                end++;
            }
        }
        return Math.max(set.size(), max);
    }

    // 推荐这个
    // 使用map存储字符和索引，如果发现重复则将begin改为begin和重复索引加一的最大值（防止begin往前跑）
    // 这样就可以保证begin和end之间的字符是没有重复的，end-begin+1就是当前长度，取最大值即可
    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < length; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                begin = Math.max(map.get(c) + 1, begin);
                map.put(c, end);
            }else {
                map.put(c, end);
            }

            maxLength = Math.max(maxLength, end - begin + 1);
        }

        return maxLength;
    }
}
