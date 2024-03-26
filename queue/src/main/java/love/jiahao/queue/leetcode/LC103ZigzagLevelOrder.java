package love.jiahao.queue.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>力扣103题二叉树的S字形层序遍历</big>
 * <p>
 * 3
 * 9   20
 * 15 7
 * 结果: 3 20,9 15,7
 * </P>
 *
 * @author 13684
 * @date 2024/1/3
 */
public class LC103ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 判断树是否为空
        if (root == null) return List.of();
        // 准备结果数据
        List<List<Integer>> result = new ArrayList<>();
        // 添加根节点到队列中
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 每层循环遍历的次数
        int temp = 1;
        boolean odd = true; // 是否为奇数层
        while (temp != 0) {
            // 下层循环的次数
            int temp2 = 0;
            // 当前层的结果
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < temp; i++) {
                // 取出队列中的节点
                TreeNode node = queue.poll();
                assert node != null;
                // 将结果加入到当前层结果中
                if (odd) {
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
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
            odd = !odd;
            result.add(list);
            temp = temp2;
        }
        return result;
    }

    static class TreeNode {
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
    }
}
