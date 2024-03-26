package love.jiahao.interview150.arrayAndString;

/**
 * <big>最后一个单词的长度</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC58LengthOfLastWord {
    public static void main(String[] args) {

    }

    // 去除空格后，从后往前遍历遇到空格计数停止
    // 也可以不去空格，第一次遇到空格开始计数，第二次停止
    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int result = 0;
        for (int i = trim.length() - 1 ; i >= 0; i--) {
            if (trim.charAt(i) != ' ') {
                result++;
                continue;
            }
            break;
        }
        return result;
    }
}
