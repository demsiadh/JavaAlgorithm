package love.jiahao.interview150.hashTable;

import java.util.*;

/**
 * <big>字母异位词分组</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC49GroupAnagrams {

    /*
        设置hash表将每个字符串映射上去，将生成的hash表作为key，集合作为value
        创建map，添加当前字符串到对应hash表中的集合中
        最终返回map的所有values
     */
    public List<List<String>> groupAnagrams(String[] strs) {    // 99 57
        Map<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey arrayKey = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(arrayKey, k -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static class ArrayKey{
        int[] key = new int[26];
        // a = 97
        public ArrayKey(String s) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                key[c - 97]++;
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
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }
    }
}
