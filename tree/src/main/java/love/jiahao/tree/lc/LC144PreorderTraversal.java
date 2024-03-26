package love.jiahao.tree.lc;

import love.jiahao.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>力扣144题-二叉树的前序遍历</big>
 *
 * @author 13684
 * @date 2024/3/1
 */
public class LC144PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        TreeNode pop = null;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                result.add(temp.value);
                temp = temp.left;
            }else{
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                }else if(peek.right == pop){
                    pop = stack.pop();
                }else{
                    temp = peek.right;
                }
            }

        }
        return result;
    }
}
