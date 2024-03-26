package love.jiahao.recursion;

/**
 * <p>杨辉三角(记忆法-二位数组)</p>
 * <ul>
 *     <li>1</li>
 *     <li>1    1</li>
 *     <li>1    2   1</li>
 *     <li>1    3   3   1</li>
 *     <li>1    4   6   4   1</li>
 * </ul>
 *
 * @author 13684
 * @date 2023/11/29
 */
public class E15PascalTriangle {

    public static void main(String[] args) {
        print(10);
    }

    /**
     * 打印杨辉三角
     *
     * @param m 高度
     */
    public static void print(int m) {
        // 初始创建二维数组由于每一行的列数不一样，就不先指定列数
        int[][] cache = new int[m][];
        for (int i = 1; i <= m; i++) {
            // 每列一共i个元素
            cache[i - 1] = new int[i];
            // 将每行第一个元素填充上1，还有每行最后一个元素填充上1
            cache[i - 1][0] = 1;
            cache[i - 1][i - 1] = 1;
            printSpace((m - i) * 2);
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", element(i, j, cache));
            }
            System.out.println();
        }
    }

    /**
     * 打印空格对齐三角
     *
     * @param n 需要打印几个
     */
    private static void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    /**
     * <p>获取对应行列的值</p>
     * <ul>
     *     <li>当前元素=上一行同列元素+上一行上一列的元素</li>
     * </ul>
     *
     * @param i 行
     * @param j 列
     * @return 当前元素
     */
    private static int element(int i, int j, int[][] cache) {
        if (cache[i - 1][j - 1] > 0) return cache[i - 1][j - 1];

        cache[i - 1][j - 1] = element(i - 1, j, cache) + element(i - 1, j - 1, cache);

        return cache[i - 1][j - 1];
    }
}
