package love.jiahao.interview150.hashTable;

import java.util.Arrays;

/**
 * <big>字母异位词</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC242IsAnagram {
    /*
        利用hash表，将其对应转化为数组
        判断数组是否相等即可
     */
    public boolean isAnagram(String s, String t) {
        ArrayKey arrayKey1 = new ArrayKey(s);
        ArrayKey arrayKey2 = new ArrayKey(t);
        return arrayKey1.equals(arrayKey2);
    }

    private static class ArrayKey{
        int[] key = new int[26];

        public ArrayKey(String s) {
            for (char c : s.toCharArray()) {
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
