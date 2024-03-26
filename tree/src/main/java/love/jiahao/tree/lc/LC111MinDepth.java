package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

import java.util.LinkedList;

/**
 * <big>力扣111题-二叉树的最小深度</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC111MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        LC111MinDepth lc111MinDepth = new LC111MinDepth();
        System.out.println(lc111MinDepth.minDepth2(root));
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        // 防止节点没有子节点
        if (d1 == 0) return d2 + 1;
        if (d2 == 0) return d1 + 1;
        return Integer.min(d1, d2) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = 1;
        while (!queue.isEmpty()) {
            // 下层循环的次数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left == null && node.right == null) return min;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            min++;
        }
        return min;
    }
}
