package love.jiahao.interview150.doublePointer;

import java.util.Arrays;

/**
 * <big>验证回文串</big>
 *
 * @author 13684
 * @date 2024/3/25
 */
public class LC125IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    /*
        1. 首先将字符串进行处理，转化为全身是小写字母的字符串
        2. 遍历字符串，采用两个指针，一个从头，一个从尾 每次头指针++ 尾指针--
        3. 如果字符不相等则返回false 直到头指针大于等于尾指针
     */
    public static boolean isPalindrome(String s) {  // 9 7
        String[] split = s.toLowerCase().split("[^A-Za-z0-9]+");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            sb.append(s1);
        }
        String str = sb.toString();
        int length = str.length();
        if (length <= 1) {
            return true;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
    /*
        和上面几乎同理 只不过处理字符的方式变为了采用Character的api来验证
        使用StringBuilder来拼接字符串，然后进行验证处理
     */
    public static boolean isPalindrome2(String s) {  // 66 46
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
