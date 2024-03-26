package love.jiahao.stack;


/**
 * <big>力扣20题-判断括号是否有效</big>
 * <p>s= "()" 有效</p>
 * <p>s= "{)" 无效</p>
 *
 * @author 13684
 * @date 2023/12/10
 */
public class LC20IsValid {
    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(isValid(s));
    }

    /**
     * <p>整体思路-利用栈的特性解决</p>
     * <p>将字符串作为一个字符数组看待，从第一个开始如果碰到([{</p>
     * <p>就往栈中压入相应的)]},如果碰到右括号，就取出栈中的元素根当前元素对比</p>
     * <p>如果不相等就是无效括号,如果为空也是无效括号(为空证明直接是右括号，或者左括号消耗完了)</p>
     * @param s     要判断的字符串
     * @return      括号是否有效
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) return false;
        ArrayStack<Character> chars = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> chars.push(')');
                case '[' -> chars.push(']');
                case '{' -> chars.push('}');
                default -> {
                    if (chars.peek() == null) return false;
                    else {
                        if (chars.pop() != c) return false;
                    }
                }
            }
        }
        return chars.isEmpty();
    }
}
