package love.jiahao.interview150.binaryTree;


/**
 * <big>力扣 129. 求根到叶子节点数字之和</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/20 下午8:50
 */
public class LC129SumNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(sumNumbers(root));
        System.out.println(dfs2(root, 0));
    }

    /**
     * 自己的解法，深度优先遍历
     * 递归到每个叶子节点，将来时的路拼接成字符串，到叶子节点就拼接最后的值并打上一个标识符
     * 然后将每条路的结果都拼起来，最后将结果求和
     * 时间和空间比较不理想
     * @param root  根节点
     * @return  和
     */
    public static int sumNumbers(TreeNode root) {
        String dfs = dfs(root, "");
        String[] split = dfs.split(";");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static String dfs(TreeNode root, String s) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return s + root.val + ";";
        }
        return dfs(root.left, s + root.val) + dfs(root.right, s + root.val);
    }

    /**
     * 官方题解，递归
     * 深度优先遍历，但是每次向下递归时，直接将父节点的值*10 + 当前节点的值
     * 避免了字符串拼接，效率更高
     * @param root 根节点
     * @return 和
     */
    public static int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    private static int dfs2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }else {
            return dfs2(root.left, sum) + dfs2(root.right, sum);
        }
    }
}
