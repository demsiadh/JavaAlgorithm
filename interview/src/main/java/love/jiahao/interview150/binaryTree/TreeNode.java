package love.jiahao.interview150.binaryTree;

/**
 * <big>二叉树的节点</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/5/15 下午3:52
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
