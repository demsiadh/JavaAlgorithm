package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

/**
 * <big>力扣101题-对称二叉树</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC101IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isSymmetric(treeNode));


    }
}
