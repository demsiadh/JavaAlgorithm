package love.jiahao.tree.lc;

/**
 * <big>力扣700题-查询二叉搜索中的节点</big>
 *
 * @author 13684
 * @date 2024/3/3
 */
public class lC700SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode temp = root;
        while (temp != null) {
            if (val > temp.val) {
                temp = temp.right;
            } else if (val < temp.val) {
                temp = temp.left;
            }else {
                return temp;
            }
        }
        return null;
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
