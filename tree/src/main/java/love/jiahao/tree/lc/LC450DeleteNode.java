package love.jiahao.tree.lc;

/**
 * <big>力扣450题-删除二叉搜索树对应key的节点</big>
 *
 * @author 13684
 * @date 2024/3/3
 */
public class LC450DeleteNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, null, null);
        LC450DeleteNode node = new LC450DeleteNode();
        System.out.println(node.deleteNode(root, 0));
    }

    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }
        if (node.left == null) { // 情况1 - 只有右孩子
            return node.right;
        }
        if (node.right == null) { // 情况2 - 只有左孩子
            return node.left;
        }
        TreeNode s = node.right; // 情况3 - 有两个孩子
        while (s.left != null) {
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
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
