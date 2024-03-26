package love.jiahao.stack;

import java.util.Stack;

/**
 * <big>中缀表达式转为后缀</big>
 * @author 13684
 * @date 2023/12/11
 */
public class E01InfixToSuffix {
    public static void main(String[] args) {
        String s = "(a+b*c-d)/e";
        System.out.println(infixToSuffix2(s));

        String s1 = "a*(b+c)";
        System.out.println(infixToSuffix2(s1));
    }

    /**
     * <p>思路分析，我们用栈来保存运算符(这里没有考虑括号情况)</p>
     * <p>如果碰到数字就直接拼入结果字符串</p>
     * <p>碰到运算符，首先与栈顶中的运算符比较优先级</p>
     * <p>如果栈顶的运算符优先级大于等于他就出栈，拼入字符串</p>
     * <p>栈顶元素优先级低就把当前运算符压入栈</p>
     * <p>最后到字符串的末尾将最后的运算符拼入字符串</p>
     * <p>a+b*c -> abc*+</p>
     * @param exp   传入的中缀表达式字符串
     * @return      处理后的后缀表达式字符串
     */
    @SuppressWarnings("all")
    public static String infixToSuffix(String exp) {
        if (exp.isEmpty()) return null;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (isNumber(c)) result.append(c);
            else {
                if (stack.size() > 0) {
                    if (priority(c) > priority(stack.peek())) {
                        stack.push(c);
                    } else {
                        while (stack.size() > 0 && priority(stack.peek()) >= priority(c)) {
                            result.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }else stack.push(c);
            }
        }
        while (stack.size() > 0) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    /**
     * <p>思路分析，我们用栈来保存运算符(考虑括号情况)</p>
     * <p>碰到左括号就进站，当碰到右括号时就把运算符全部弹出栈，一直到左括号弹出</p>
     * <p>括号在栈中运算符优先级是最低</p>
     * @param exp   传入的中缀表达式字符串
     * @return      处理后的后缀表达式字符串
     */
    @SuppressWarnings("all")
    public static String infixToSuffix2(String exp) {
        if (exp.isEmpty()) return null;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (isNumber(c)) result.append(c);
            else {
                switch (c){
                    case '(' -> stack.push(c);
                    case ')' -> {
                        while (stack.peek() != '(') {
                            result.append(stack.pop());
                        }
                        stack.pop();
                    }
                    default -> {
                        if (stack.size() > 0) {
                            if (priority(c) > priority(stack.peek())) {
                                stack.push(c);
                            } else {
                                while (stack.size() > 0 && priority(stack.peek()) >= priority(c)) {
                                    result.append(stack.pop());
                                }
                                stack.push(c);
                            }
                        }else stack.push(c);
                    }
                }
            }
        }
        while (stack.size() > 0) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    /**
     * <p>判断是否为数字</p>
     * @param c 字符
     * @return  是否为数字
     */
    public static boolean isNumber(char c) {
        return !(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c== ')');
    }

    /**
     * <p>计算运算符的优先级</p>
     * @param c 运算符
     * @return  优先级
     */
    public static int priority(char c) {
        switch (c){
            case '(', ')' -> {
                return 0;
            }
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
        }
        throw new IllegalArgumentException(c + "运算符不存在!");
    }
}
