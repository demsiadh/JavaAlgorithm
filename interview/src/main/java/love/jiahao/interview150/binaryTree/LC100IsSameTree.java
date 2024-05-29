package love.jiahao.interview150.binaryTree;

/**
 * <big>力扣100题-判断两个二叉树是否一致</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/5/29 上午9:29
 */
public class LC100IsSameTree {
    /*
     * 递归解法
     * 深度优先遍历
     * 所有结果均返回true才认为相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
