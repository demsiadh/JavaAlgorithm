package love.jiahao.hash.lc;

/**
 * <big>找出字符串中第一个唯一字符</big>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC387FirstUniqChar {
    /*
        继续使用位图，因为题目中要求都是小写字母，将字母放入数组中
        1. 首先将字符对应的位置加加
        2. 再次遍历字符串找到第一个数组响应位置为1的字符
     */
    public int firstUniqChar(String s) { // 93 71
        int[] ints = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            ints[c - 97]++;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (ints[charArray[i] - 97] == 1) {
                return i;
            }
        }

        return -1;
    }
}
