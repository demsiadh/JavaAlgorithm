package love.jiahao.interview150.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC03LengthOfLongestSubstring {
    /*
        利用hashmap的特性排除重复的字符串，设置头尾指针
        map的key为字符，值为索引，如果遇到重复的，则start右移
        每次记录最大长度
     */
    public int lengthOfLongestSubstring(String s) { // 90 57
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for (int end = 0; end < length; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
                map.put(c, end);
            }else {
                map.put(c, end);
            }
            max = Math.max(end - start + 1, max);
        }

        return max;
    }
}
