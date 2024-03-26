package love.jiahao.tree;

import java.util.LinkedList;

/**
 * <big>树的遍历方式</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class TreeTraversal {
    public static void main(String[] args) {
        /*
                 1
              2    3
           4     5   6
         */
        TreeNode root = new TreeNode(
                1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), new TreeNode(6))
        );
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println();
        inOrder2(root);
        System.out.println();
        postOrder2(root);
    }

    /**
     * <h2>前序遍历（递归）</h2>
     *
     * @param node 树的根节点
     */
    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * <h2>前序遍历（非递归）</h2>
     *
     * @param node 树的根节点
     */
    public static void preOrder2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = node;
        while (temp != null || !stack.isEmpty()){
            if (temp != null) {
                stack.push(temp);
                System.out.print(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                temp = temp.right;
            }
        }
    }


    /**
     * <h2>中序遍历（递归）</h2>
     *
     * @param node 树的根节点
     */
    public static void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + "\t");
        inOrder(node.right);
    }

    /**
     * <h2>中序遍历（非递归）</h2>
     *
     * @param node 树的根节点
     */
    public static void inOrder2(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = node;
        while (temp != null || !stack.isEmpty()){
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp);
                temp = temp.right;
            }
        }
    }

    /**
     * <h2>后序遍历（递归）</h2>
     * @param node 树的根节点
     */
    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + "\t");

    }
    /**
     * <h2>后序遍历（递归）</h2>
     * @param node 树的根节点
     */
    public static void postOrder2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = node;   // 临时节点
        TreeNode pop = null;   // 最近一次弹栈元素
        while (temp != null || !stack.isEmpty()){
            if (temp != null) {
                stack.push(temp);
                // 待处理左子树
                System.out.print("前" + temp);
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    System.out.print("中" + peek);
                    pop = stack.pop();
                    System.out.print("后" + pop);
                // 处理右子树
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.print("后" + pop);
                // 待处理右子树
                } else {
                    System.out.print("中" + peek);
                    temp = peek.right;
                }
            }
        }
    }
}
