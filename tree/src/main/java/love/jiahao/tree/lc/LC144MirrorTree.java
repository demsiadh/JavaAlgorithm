package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

/**
 * <big>力扣144题-反转二叉树</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC144MirrorTree {
    @SuppressWarnings("all")
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
