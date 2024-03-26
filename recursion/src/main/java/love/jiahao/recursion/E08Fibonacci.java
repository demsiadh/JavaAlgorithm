package love.jiahao.recursion;

/**
 * 斐波那契数列(递归计算)
 */
public class E08Fibonacci {

    public static void main(String[] args) {
        System.out.println(handler(12));
    }

    /**
     * 计算斐波那契数列对应位置的值
     * <p>时间复杂度1.618^n</p>
     * @param n     位置索引
     * @return      对应的值
     */
    private static int handler(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        return handler(n - 1) + handler(n - 2);
    }
}
