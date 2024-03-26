package love.jiahao.tree.lc;

import java.util.LinkedList;

/**
 * <big>力扣98题-验证二叉搜索树</big>
 *
 * @author 13684
 * @date 2024/3/3
 */
public class LC98IsValidBST {
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

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        TreeNode temp = root;
        TreeNode pop = null;
        long prev = Long.MIN_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    if (peek.val <= prev) return false;
                    prev = peek.val;
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    pop = stack.pop();
                }else {
                    if (peek.val <= prev) return false;
                    prev = peek.val;
                    temp = peek.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        LC98IsValidBST lc98IsValidBST = new LC98IsValidBST();
        System.out.println(lc98IsValidBST.isValidBST(treeNode));
    }
}
