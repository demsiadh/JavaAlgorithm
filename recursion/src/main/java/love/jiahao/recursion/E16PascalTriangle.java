package love.jiahao.recursion;

/**
 * <p>杨辉三角(记忆法-一维数组)</p>
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
public class E16PascalTriangle {

    public static void main(String[] args) {
        print(10);
    }

    /**
     * 打印杨辉三角
     *
     * @param m 高度
     */
    public static void print(int m) {
        int[] row = new int[m];
        for (int i = 1; i <= m; i++) {
            // 获取当前行的元素
            createRow(row, i);
            printSpace((m - i) * 2);
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", row[j - 1]);
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
     * <p>获得当前行的所有数据</p>
     * <ul>
     *     <li>由于当前行都是由上一行得到的，所以我们知道了上一行的数组就可以直接求解</li>
     *     <li>1 3 3 1 0</li>
     *     <li>1 4 6 4 1 每个数都等于当前位置数加上一个位置的数</li>
     * </ul>
     * @param row   当前行数组
     * @param n     第几行
     */
    private static void createRow(int[] row, int n) {
        if (n == 1) {
            row[0] = 1;
            return;
        }
        // 倒着遍历
        for (int i = n - 1; i > 0; i--) {
            row[i] = row[i - 1] + row[i];
        }
    }
}
