package love.jiahao.interview150.binaryTree;

import java.util.Arrays;

/**
 * <big>力扣106. 从中序与后序遍历序列构造二叉树</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/4 上午9:46
 */
public class LC106BuildTree {
    /**
     * 根据中序遍历和后序遍历的结果重建二叉树。
     *
     * @param inOrder 中序遍历结果数组。
     * @param postOrder 后序遍历结果数组。
     * @return 重建后的二叉树的根节点。
     */
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        // 当中序遍历数组为空时，返回null，表示树为空。
        if (inOrder.length == 0) {
            return null;
        }
        // 后序遍历的最后一个元素是根节点。
        int rootValue = postOrder[postOrder.length - 1];
        // 创建根节点。
        TreeNode root = new TreeNode(rootValue);
        // 遍历中序遍历数组，找到根节点的位置。
        for (int i = 0; i < inOrder.length; i++) {
            // 当找到根节点时，分割数组构建左右子树。
            if (inOrder[i] == rootValue) {
                // 分割中序遍历数组，得到左子树的中序遍历数组。
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                // 分割中序遍历数组，得到右子树的中序遍历数组。
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                // 分割后序遍历数组，得到左子树的后序遍历数组。
                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i);
                // 分割后序遍历数组，得到右子树的后序遍历数组。
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1);

                // 递归构建左子树。
                root.left = buildTree(inLeft, postLeft);
                // 递归构建右子树。
                root.right = buildTree(inRight, postRight);
            }
        }
        // 返回根节点。
        return root;
    }

}
