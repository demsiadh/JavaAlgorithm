package love.jiahao.hash.lc;

import java.util.Arrays;

/**
 * <big>有效的字母异位词</big>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC242IsAnagram {
    /*
        采用位图思想，每个字符串中的字符对应一个位置，出现几次就改为几，比对位图是否相等即可判断是否异位词
        前提： 1.题目说明字母仅有小写字母组成 —— 可以确定数组长度
        思想可参考49题目
     */
    private static class ArrayKey{
        int[] key = new int[26];

        public ArrayKey(String s) {
            for (char c : s.toCharArray()) {    // 91 41
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

    public boolean isAnagram(String s, String t) {  // 82 63
        ArrayKey arrayKey1 = new ArrayKey(s);
        ArrayKey arrayKey2 = new ArrayKey(t);
        return arrayKey1.equals(arrayKey2);
    }
}
