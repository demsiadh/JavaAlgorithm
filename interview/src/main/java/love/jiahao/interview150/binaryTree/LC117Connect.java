package love.jiahao.interview150.binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <big>力扣 117. 填充每个节点的下一个右侧节点指针</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/6 下午5:43
 */
public class LC117Connect {
    /**
     * 层序遍历暴力解法，先遍历出所有元素，放入集合中
     * 然后遍历集合，更改next指向，效率低
     * @param root 根节点
     * @return 处理后的根节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int nextCount = 0;
            List<Node> nodes = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                Node poll = queue.remove();
                if (poll.left != null) {
                    nextCount++;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    nextCount++;
                    queue.add(poll.right);
                }
                nodes.add(poll);
            }
            list.add(nodes);
            count = nextCount;
        }

        for (List<Node> nodes : list) {
            for (int i = 0; i < nodes.size(); i++) {
                if (i == nodes.size() - 1) {
                    nodes.get(i).next = null;
                } else {
                    nodes.get(i).next = nodes.get(i + 1);
                }
            }
        }

        return root;
    }

    /**
     * 层序遍历的变种，遍历的时候改变next指向，效率更高
     * @param root  根节点
     * @return  处理完的结果
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nextCount = queue.size();
            for (int i = 0; i < nextCount; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (i != nextCount - 1) {
                    poll.next = queue.peek();
                }else {
                    poll.next = null;
                }
            }
        }
        return root;
    }
}
