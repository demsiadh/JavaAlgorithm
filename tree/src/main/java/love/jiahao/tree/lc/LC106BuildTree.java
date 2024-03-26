package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

import java.util.Arrays;

/**
 * <big>力扣106题-根据中序遍历和后序遍历结果构造树</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC106BuildTree {
    /*
            1
          2   3
        4    6  7
        inorder {4, 2, 1, 6, 3, 7}
        postorder {4. 2. 6. 7. 3. 1}
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                // 右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                // 左子树
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                // 右子树
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
