package love.jiahao.stack;

import java.util.Stack;

/**
 * <big>力扣150题-逆波兰表达式求值</big>
 * <p>其实编译的时候就把我们写的中缀表达式转换为了后缀表达式</p>
 *
 * @author 13684
 * @date 2023/12/10
 */
public class LC150EvalRPN {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
        int a = 10;
        int b = 20;
        int d = 5;
        int c = a + b * d;
        System.out.println(c);
    }

    public static int evalRPN(String[] tokens) {
        ArrayStack<Integer> stack = new ArrayStack<>(tokens.length);
        for (String token : tokens) {
            if (isNumber(token)) stack.push(Integer.valueOf(token));
            else {
                Integer int1 = stack.pop();
                Integer int2 = stack.pop();
                switch (token) {
                    case "*" -> stack.push((int) int1 * int2);
                    case "-" -> stack.push(int2 - int1);
                    case "+" -> stack.push(int2 + int1);
                    case "/" -> stack.push((int) int2 / int1);
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
