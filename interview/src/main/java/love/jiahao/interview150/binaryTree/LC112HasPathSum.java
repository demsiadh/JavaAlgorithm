package love.jiahao.interview150.binaryTree;

import java.util.Optional;
import java.util.Stack;

/**
 * <big>力扣 112. 路径总和</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 下午2:55
 */
public class LC112HasPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1));
        hasPathSum(treeNode, 0);
    }



    /**
     * 检查二叉树中是否存在从根节点到叶子节点的路径，路径上所有节点值的和等于给定的sum。
     *
     * @param root 二叉树的根节点
     * @param sum 目标和
     * @return 如果存在路径的节点值和等于sum，则返回true；否则返回false。
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        // 遍历到叶子节点，还没返回true直接返回false
        if (root == null) {
            return false;
        }

        // 如果当前节点是叶子节点，并且节点值等于sum，则返回true
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        // 深度优先遍历
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
