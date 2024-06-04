package love.jiahao.interview150.binaryTree;

import java.util.Arrays;

/**
 * <big>力扣 105. 从前序与中序遍历序列构造二叉树</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/4 上午9:31
 */
public class LC105BuildTree {
    /**
     * 根据前序遍历和中序遍历的结果重建二叉树。
     * 前序遍历的特点是根节点在前，然后是左子树，最后是右子树。
     * 中序遍历的特点是左子树在前，然后是根节点，最后是右子树。
     * 通过前序遍历可以确定根节点，然后在中序遍历中找到根节点的位置，从而划分左右子树。
     * 对左右子树分别递归调用本方法，直到构建完整的二叉树。
     *
     * @param preOrder 前序遍历结果数组
     * @param inOrder 中序遍历结果数组
     * @return 构建的二叉树的根节点
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        // 如果前序遍历数组为空，则返回空
        if (preOrder.length == 0) {
            return null;
        }
        // 以前序遍历的第一个元素作为根节点
        // 创建根节点
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        // 遍历中序遍历数组，找到根节点的位置，以划分左右子树
        // 区分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                // 划分左子树的中序遍历数组
                // 左子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                // 划分右子树的中序遍历数组
                // 右子树
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                // 划分左子树的前序遍历数组
                // 左子树
                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                // 划分右子树的前序遍历数组
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
                // 递归构建左子树
                root.left = buildTree(preLeft, inLeft);
                // 递归构建右子树
                root.right = buildTree(preRight, inRight);
                // 找到划分点后跳出循环
                break;
            }
        }
        // 返回构建好的二叉树的根节点
        return root;
    }
}
