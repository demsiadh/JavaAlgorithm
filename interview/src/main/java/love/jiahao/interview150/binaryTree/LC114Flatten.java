package love.jiahao.interview150.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <big>力扣114题 二叉树展开为链表</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 上午9:34
 */
public class LC114Flatten {
    /**
     * <p>根据前序遍历结果进行拼接</p>
     *
     * @param root  根节点
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pop = null;
        TreeNode temp = root;
        List<TreeNode> list = new ArrayList<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                list.add(temp);
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                // 没有右孩子
                if (peek.right == null) {
                    pop = stack.pop();
                    // 如果上一个节点是右孩子，证明当前节点处理完了
                } else if (peek.right == pop) {
                    pop = stack.pop();
                }else {
                    // 处理右孩子
                    temp = peek.right;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).left = null;
                list.get(i).right = null;
                break;
            }
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }
}
