package love.jiahao.interview150.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <big>逆波兰表达式</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC150EvalRPN {
    /*
        创建一个栈，如果没碰到运算符号就填入元素，如果碰到运算符号
        就从栈中取出两个元素进行运算，并将运算结果放入栈中(结果肯定也要记录的)
     */

    @SuppressWarnings("all")
    public int evalRPN(String[] tokens) {   // 93 70
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*" -> {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();
                    stack.push((int) int1 * int2);
                }
                case "-" -> {
                    Integer int3 = stack.pop();
                    Integer int4 = stack.pop();
                    stack.push(int4 - int3);
                }
                case "+" -> {
                    Integer int5 = stack.pop();
                    Integer int6 = stack.pop();
                    stack.push(int6 + int5);
                }
                case "/" -> {
                    Integer int7 = stack.pop();
                    Integer int8 = stack.pop();
                    stack.push((int) int8 / int7);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
