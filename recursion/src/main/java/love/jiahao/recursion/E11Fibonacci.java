package love.jiahao.recursion;

import java.util.Arrays;

/**
 * <h2>优化斐波那契数列递归</h2>
 */
public class E11Fibonacci {
    public static void main(String[] args) {
        // 因为int占四个字节，所以存储范围时-2_147_483_648 - 2_147_483_647
        // 计算过多会出现负数情况
        System.out.println(fibonacci(48));
    }

    /**
     * <h3>优化（记忆法）</h3>
     * <ul>
     *     <li>创建一个数组，初始长度为要求值的+1，因为第几位的结果在数组的索引几</li>
     *     <li>后续计算出结果就存入数组，数组种有结果就直接拿数组的</li>
     *     <li>大大提高了效率，从指数时间复杂度变为线性O(n)</li>
     * </ul>
     * @param n 斐波那契的第几项
     * @return  值
     */
    public static int fibonacci(int n) {

        int[] cache = new int[n + 1];
        // 填充初始值
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return handler(n, cache);
    }


    public static int handler(int n, int[] cache) {
        // 如果在数组中找到直接返回
        if (cache[n] != -1) return cache[n];
        // 找不到就计算
        int x = handler(n - 1, cache);
        int y = handler(n - 2, cache);
        // 计算出来时再存入数组
        cache[n] = x + y;
        return cache[n];
    }
}
