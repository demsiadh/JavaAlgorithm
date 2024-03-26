package love.jiahao.hash.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <big>字母异位词分组</big>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC49GroupAnagrams {
    public static void main(String[] args) {

    }

    // 首先对字符串进行排序，如果map中有当前字符串则添加进value的list中
    // 如果map中没有则put上去一个新的list，最终map的values就是要找的答案
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            // 如果不缺就get 缺失就做后面的操作
            List<String> list = map.computeIfAbsent(s, k -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }

    // 位图思想实现
    // 由于题目限制26英文字母，因此可以创建一个数组长度26，将字符串转化为数组，对应的位置标为1
    // 即可作为唯一标识，由于数组本身没有hashcode方法无法作为key，所以设计一个对象
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

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey arrayKey = new ArrayKey(str);
            // 如果不缺就get 缺失就做后面的操作
            List<String> list = map.computeIfAbsent(arrayKey, k -> new ArrayList<>());
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }
}
