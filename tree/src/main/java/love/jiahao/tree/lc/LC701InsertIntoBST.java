package love.jiahao.tree.lc;

/**
 * <big>力扣701题-二叉搜索树的插入操作</big>
 *
 * @author 13684
 * @date 2024/3/3
 */
public class LC701InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 树为空
        if (root == null) return new TreeNode(val);
        TreeNode temp = root;
        TreeNode parent = null;
        while (temp != null) {
            parent = temp;
            if (val > temp.val) {
                temp = temp.right;
            }else {
                temp = temp.left;
            }
        }

        if (val > parent.val) parent.right = new TreeNode(val);
        else parent.left = new TreeNode(val);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
