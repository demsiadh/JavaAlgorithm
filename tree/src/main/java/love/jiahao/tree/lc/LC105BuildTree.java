package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

import java.util.Arrays;

/**
 * <big>力扣105题-根据前序遍历和中序遍历构造二叉树</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC105BuildTree {
    /*
            1
          2   3
        4    6  7
      preOrder {1, 2, 4, 3, 6, 7}
      inOrder {4, 2, 1, 6, 3, 7}
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0) return null;
        // 创建根节点
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                // 左子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                // 右子树
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                // 左子树
                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                // 右子树
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
