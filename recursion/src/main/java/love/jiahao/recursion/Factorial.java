package love.jiahao.recursion;

/**
 * 使用递归求阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        int handler = handler(0);
        System.out.println(handler);
    }

    private static int handler(int m) {
        if (m == 0) return 1;
        return handler(m - 1) * m;
    }
}
