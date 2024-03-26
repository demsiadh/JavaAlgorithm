package love.jiahao.recursion;

/**
 * <h2>斐波那契数列解决兔子问题</h2>
 */
public class E09Fibonacci {
    public static void main(String[] args) {
        System.out.println(handler(20));
    }

    /**
     * <h3>兔子问题</h3>
     * <ul>
     *     <li>第一个月有一对未成熟的兔子</li>
     *     <li>第二个月成熟了</li>
     *     <li>第三个月产下一对新的小兔子</li>
     *     <li>所有兔子都遵循归类，求第n个月有多少兔子</li>
     * </ul>
     * <p>n个月的兔子 = 上月的兔子 + 上月成熟的兔子数</p>
     * <p>也就是上个月的兔子+上上个月的兔子</p>
     * @param mouth     过几个月
     * @return          兔子总数
     */
    private static int handler(int mouth) {
        if (mouth <= 0) throw new IllegalArgumentException("非法参数!");
        // 前两个月只有刚开始的俩兔子
        if (mouth == 1 || mouth == 2) return 2;

        return handler(mouth - 1) + handler(mouth - 2);
    }
}
