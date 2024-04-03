package love.jiahao.interview150.stack;

import java.util.LinkedList;

/**
 * <big>有效括号</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC20IsValid {

    /*
        将左边的括号添加到栈中，如果碰到右边的括号
        就弹出栈，查看弹出元素是否需要的括号
        如果此时栈中元素为0就说明没有对应的左括号也返回false
        最终如果栈中不存在元素则返回true
     */
    public boolean isValid(String s) {  // 98 77
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            switch (c) {
                case ')' -> {
                    if (stack.size() == 0 || stack.poll() != '(') {
                        return false;
                    }
                }
                case  '}' -> {
                    if (stack.size() == 0 || stack.poll() != '{') {
                        return false;
                    }
                }
                case  ']' -> {
                    if (stack.size() == 0 || stack.poll() != '[') {
                        return false;
                    }
                }
                default -> stack.push(c);
            }
        }

        return stack.size() == 0;
    }
}
