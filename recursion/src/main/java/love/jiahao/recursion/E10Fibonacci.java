package love.jiahao.recursion;

/**
 * <h2>斐波那契数列解决青蛙爬楼梯问题</h2>
 */
public class E10Fibonacci {
    public static void main(String[] args) {
        System.out.println(handler(4));
    }

    /**
     * <h3>青蛙爬楼梯</h3>
     * <ul>
     *     <li>楼梯有n个台阶</li>
     *     <li>青蛙一次可以跳一个或两个台阶</li>
     *     <li>只能向上跳，一共有多少个跳法</li>
     * </ul>
     * <p>假如需要跳到n阶，青蛙的最后一眺一定是在n-1或者n-2个台阶上</p>
     * <p>因为青蛙一次只能跳一个或两个台阶，所以n阶的方式就是n-1加上n-2</p>
     * <p>这也就是我们斐波那契数列的思想</p>
     * @param n 一共多少台阶
     * @return  一共多少种跳法
     */
    public static int handler(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return handler(n - 1) + handler(n - 2);
    }
}
