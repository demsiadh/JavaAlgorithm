package love.jiahao.tree;

/**
 * <big>树的节点类</big>
 * @author 13684
 * @date 2024/3/1
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return value + "\t";
    }
}
