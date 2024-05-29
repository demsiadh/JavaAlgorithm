package love.jiahao.interview150.binaryTree;

/**
 * <big>翻转二叉树</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/5/29 上午10:29
 */
public class LC226InvertTree {
    /*
     * 递归
     * 先翻转左子树，再翻转右子树，最后交换左右子树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
