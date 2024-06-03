package love.jiahao.interview150.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <big>力扣 101. 对称二叉树</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/3 上午9:44
 */
public class LC101IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 判断两个节点是否对称
     * 递归解法
     * @param root1 左节点
     * @param root2 右节点
     * @return
     */
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root2 == null) {
            return false;
        }

        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * 判断二叉树是否对称
     * 1. 使用一个队列来保存二叉树节点，按照左右节点顺序入队
     * 2. 循环到队列为空，每次取出两个节点判断是否相等
     * 3. 直到队列为空，还不返回，则证明树对称
     * @param root 根节点
     * @return  是否对称
     */
    private boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }

            if ((t1 == null || t2 == null) || t1.val != t2.val) {
                return false;
            }

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }
}
