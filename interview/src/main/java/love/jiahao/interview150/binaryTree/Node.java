package love.jiahao.interview150.binaryTree;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/6 下午5:43
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
