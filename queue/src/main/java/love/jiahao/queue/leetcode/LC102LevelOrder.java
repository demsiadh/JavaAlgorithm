package love.jiahao.queue.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>力扣102题-二叉树的层序遍历</big>
 *
 * @author 13684
 * @date 2023/12/10
 */
public class LC102LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    /**
     * 层序遍历
     * 1
     * 2   3
     * 4  5   7
     * <p>结果就是123457</p>
     * <p>一层一层遍历</p>
     * <p>这里利用队列实现，首先就是把根节点加入队列，取出节点，</p>
     * <p>如果有左右孩子就把左右孩子加入队列，直到队列中不存在元素</p>
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 判断树是否为空
        if (root == null) return List.of();
        // 准备结果数据
        List<List<Integer>> result = new ArrayList<>();
        // 添加根节点到队列中
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 每层循环遍历的次数
        int temp = 1;
        while (temp != 0) {
            // 下层循环的次数
            int temp2 = 0;
            // 当前层的结果
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp; i++) {
                // 取出队列中的节点
                TreeNode node = queue.poll();
                assert node != null;
                // 将结果加入到当前层结果中
                list.add(node.val);
                // 如果有左节点就加入队列，然后增加下层的循环次数
                if (node.left != null) {
                    queue.offer(node.left);
                    temp2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    temp2++;
                }
            }
            result.add(list);
            temp = temp2;
        }
        return result;
    }


    public static class TreeNode {
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
            return String.valueOf(this.val);
        }
    }
}
