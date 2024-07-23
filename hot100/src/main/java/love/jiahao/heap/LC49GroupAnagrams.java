package love.jiahao.heap;

import java.util.*;

/**
 * <big>LC49</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/23 上午10:46
 */
public class LC49GroupAnagrams {
    /**
     * 思路：采用位图思想，将字符串转化为数组
     * 创建一个map来存储结果
     * 数组相同的就在同一个集合中
     * 最终返回结果
     * @param strs 字符串数组
     * @return 列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<StringToIntArray, List<String>> map = new HashMap<>();
        for (String str : strs) {
            StringToIntArray key = new StringToIntArray(str);
            List<String> strings = map.computeIfAbsent(key, k -> new ArrayList<>());
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static class StringToIntArray{
        int[] array = new int[26];
        public StringToIntArray(String str){
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object object){
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            StringToIntArray other = (StringToIntArray) object;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != other.array[i]) {
                    return false;
                }
            }
            return true;
        }



        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }
}
