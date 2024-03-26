package love.jiahao.interview150.doublePointer;

/**
 * <big>判断子序列</big>
 *
 * @author 13684
 * @date 2024/3/25
 */
public class LC392IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "abbgdc"));
    }

    /*
        1. 如果子串的长度大于要寻找的字符串直接返回false
        2. 双指针遍历，如果寻找字符串与子串相同 子串指针就++ 不管怎样寻找字符串都++
        3. 退出循环时，如果指针长度等于子串长度 则返回true
     */
    public static boolean isSubsequence(String s, String t) {   // 89 25
        if (s.length() > t.length()) {
            return false;
        }
        int temp = 0;
        for (int i = 0; i < t.length() && temp < s.length(); i++) {
            if (s.charAt(temp) == t.charAt(i)) {
                temp++;
            }
        }

        return temp == s.length();
    }
}
