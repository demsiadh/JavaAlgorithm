package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;
import love.jiahao.tree.TreeTraversal;

import java.util.LinkedList;

/**
 * <big>力扣104-二叉树的最大深度</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC104MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        LC104MaxDepth lc104MaxDepth = new LC104MaxDepth();
        System.out.println(lc104MaxDepth.maxDepth3(root));
    }
    /**
     * <h2>递归解法</h2>
     * @param root 根节点
     * @return 节点深度
     */
    public int maxDepth1(TreeNode root){
        if (root == null) return 0;
        return Integer.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * <h2>非递归解法</h2>
     *
     * @param root 根节点
     * @return 节点深度
     */
    public int maxDepth2(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        TreeNode pop = null;
        while (temp != null || !stack.isEmpty()){
            if (temp != null) {
                stack.push(temp);
                if (stack.size() > max) {
                    max = stack.size();
                }
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    pop = stack.pop();
                }else {
                    temp = peek.right;
                }
            }
        }
        return max;
    }

    /**
     * <h2>层序遍历解法</h2>
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            // 下层循环的次数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            max++;
        }
        return max;
    }
}
