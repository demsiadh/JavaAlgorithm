package love.jiahao.interview150.arrayAndString;

/**
 * <big>找到第一个匹配项的下标</big>
 *
 * @author 13684
 * @date 2024/3/19
 */
public class lC28StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack,String needle) {
        int length = haystack.length();
        int len = needle.length();
        if (length < len) {
            return -1;
        }
        int temp = 0;
        int p = 0;
        int start = 0;
        while (start < length) {
            if (p < length && haystack.charAt(p) == needle.charAt(temp)) {
                temp++;
                p++;
                if (temp == len) {
                    return start;
                }
            }else {
                start++;
                p = start;
                temp = 0;
            }
        }
        return -1;
    }
}
