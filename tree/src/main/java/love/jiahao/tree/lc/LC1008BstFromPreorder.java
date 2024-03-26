package love.jiahao.tree.lc;

/**
 * <big>力扣1008题-根据前序遍历结果构造二叉搜索树</big>
 *
 * @author 13684
 * @date 2024/3/4
 */
public class LC1008BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode temp = root;
        TreeNode parent = null;
        for (int i = 1; i < preorder.length; i++) {
            int node = preorder[i];
            while (temp != null) {
                parent = temp;
                if (node > temp.val) {
                    temp = temp.right;
                }else {
                    temp = temp.left;
                }

            }
            if (node > parent.val) {
                parent.right = new TreeNode(node);
            }else {
                parent.left = new TreeNode(node);
            }
            temp = root;
            parent = null;
        }
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
