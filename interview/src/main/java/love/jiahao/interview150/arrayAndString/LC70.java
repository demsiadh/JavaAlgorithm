package love.jiahao.interview150.arrayAndString;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/6/24
 */
public class LC70 {
    /**
     * 计算爬到第n个台阶的方法数。
     * 使用动态规划的思想，每一步的方法数是基于前两步的方法数之和。
     * 这里使用了三个变量p、q、r来分别表示前两个状态的方法数，以及当前状态的方法数。
     * 循环从1到n-1，逐步更新这三个变量的值，最终的r即为到达第n个台阶的方法数。
     *
     * @param n 目标台阶数
     * @return 爬到第n个台阶的方法数
     */
    public int climbStairs(int n) {
        // 初始化三个变量，p和q代表前两个状态的方法数，r代表当前状态的方法数
        int p = 0, q = 0, r = 1;
        // 从第2个台阶开始循环，直到第n-1个台阶
        for (int i = 1; i < n; i++) {
            // 更新p、q、r的值，将当前状态的方法数更新为前两个状态的方法数之和
            p = q;
            q = r;
            r = p + q;
        }
        // 返回到达第n个台阶的方法数
        return r;
    }
}
