package love.jiahao.interview150.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/5/15 下午3:51
 */
public class LC104MaxDepth{

    /**
     * 递归解法
     * @param root 树的根节点
     * @return 树的最大深度
     */
    public int maxDepth1(TreeNode root) { // 100 31
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * 层序遍历解法
     * @param root 树的根节点
     * @return 树的最大深度
     */
    public int maxDepth2(TreeNode root) { // 20 10
        if (root == null) {
            return 0;
        }
        // 初始深度
        int depth = 0;
        // 下一循环次数
        int nextCount = 1;
        // 树节点队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);
        // 直到遍历到没有节点
        while (!queue.isEmpty()) {
            // 获取下一层节点数量
            int tempCount = 0;
            // 把所有下一层的节点加入队列
            for (int i = 0; i < nextCount; i++) {

                TreeNode temp = queue.poll();
                // 如果有左子树，加入队列
                if (temp != null && temp.left != null) {
                    queue.offer(temp.left);
                    tempCount++;
                }
                // 如果有右子树，加入队列
                if (temp != null && temp.right != null) {
                    queue.offer(temp.right);
                    tempCount++;
                }
            }
            nextCount = tempCount;
            // 深度加一
            depth++;
        }
        return depth;
    }

    /**
     * 遍历解法
     * @param root 树的根节点
     * @return 树的深度
     */
    public int maxDepth3(TreeNode root) {  // 0.7 59
        int max = 0;
        if (root == null) {
            return max;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode pop = null;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                max = Math.max(max, stack.size());
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    pop = stack.pop();
                    // 右子树处理完了
                } else if (peek.right == pop) {
                    pop = stack.pop();
                }else {
                    // 处理右子树
                    temp = peek.right;
                }
            }
        }
        return max;
    }
}
