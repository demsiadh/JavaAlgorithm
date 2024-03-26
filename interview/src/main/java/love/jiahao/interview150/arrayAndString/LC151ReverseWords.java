package love.jiahao.interview150.arrayAndString;

import java.util.LinkedList;

/**
 * <big>反转字符串中的单词</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC151ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world   "));
        System.out.println(reverseWords("a good    example"));
    }

    // 首先去除首尾空格，随后对数组进行遍历，维持一个变量作为每个单词的首位的索引
    // 如果碰到不是空格则将其首位索引更改，直到碰到空格对字符串进行切分并放入栈中
    // 或者到字符串的最后一位，也将其放入栈中
    // 随后依次出栈保留最后一位元素，每个元素之间都添加一个空格
    // 最后将最后的元素拼入进去
    public static String reverseWords(String s) {
        s = s.trim();
        LinkedList<String> stack = new LinkedList<>();
        int temp = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ' && temp == -1) {
                temp = i;
            }
            if (temp != -1) {
                if (s.charAt(i) == ' ') {
                    stack.push(s.substring(temp, i));
                    temp = -1;
                } else if (i == length - 1) {
                    stack.push(s.substring(temp));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            result.append(stack.poll()).append(" ");
        }

        return result.append(stack.poll()).toString();
    }
}
