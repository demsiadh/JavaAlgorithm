package love.jiahao.tree;

import java.util.LinkedList;

/**
 * <big>练习题-后缀表达式</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class E01HouZhui {
    public static void main(String[] args) {
        String[] str = new String[]{"1", "2", "-", "3", "*"};
        E01HouZhui e01HouZhui = new E01HouZhui();
        TreeNode treeNode = e01HouZhui.domain(str);
        System.out.println(treeNode);
    }
    /**
     * 用二叉树实现后缀表达式
     */
    public TreeNode domain(String[] str) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String s : str) {
            switch (s){
                case "+","-","*","/","%" -> {
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode node = new TreeNode(s, left, right);
                    stack.push(node);
                }
                default -> {
                    stack.push(new TreeNode(s));
                }
            }
        }
        return stack.peek();
    }

    static class TreeNode{
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }

        public TreeNode(String value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
