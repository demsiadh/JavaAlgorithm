package love.jiahao.interview150.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <big>字符串中所有的字母异位词</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC438FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {     // 15 20
        ArrayKey target = new ArrayKey(p);
        List<Integer> list = new ArrayList<>();
        ArrayKey temp;
        for (int end = p.length(), start = 0; end <= s.length(); end++, start++) {
            temp = new ArrayKey(s.substring(start, end));
            if (temp.equals(target)) {
                list.add(start);
            }
        }
        return list;
    }

    // 由字符串创建出对应数组,因为题目说只有小写字母
    private static class ArrayKey{
        int[] keys = new int[26];

        public ArrayKey(String str) {
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                keys[c - 97]++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(keys, arrayKey.keys);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(keys);
        }
    }
}
