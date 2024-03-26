package love.jiahao.recursion;

/**
 * <p>杨辉三角(未优化)</p>
 * <ul>
 *     <li>1</li>
 *     <li>1    1</li>
 *     <li>1    2   1</li>
 *     <li>1    3   3   1</li>
 *     <li>1    4   6   4   1</li>
 * </ul>
 * @author 13684
 * @date 2023/11/29
 */
public class E14PascalTriangle {

    public static void main(String[] args) {
        print(10);
    }

    /**
     * 打印杨辉三角
     * @param m 高度
     */
    public static void print(int m) {
        for (int i = 1; i <= m; i++) {
            printSpace((m - i) * 2);
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    /**
     * 打印空格对齐三角
     * @param n     需要打印几个
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
     * @param i     行
     * @param j     列
     * @return      当前元素
     */
    private static int element(int i, int j) {
        if (j == 1 || i == j) return 1;
        return element(i - 1, j) + element(i - 1, j - 1);
    }
}
