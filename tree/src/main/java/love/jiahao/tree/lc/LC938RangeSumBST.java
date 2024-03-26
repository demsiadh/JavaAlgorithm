package love.jiahao.tree.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>力扣938题-二叉搜索树的范围和</big>
 *
 * @author 13684
 * @date 2024/3/4
 */
public class LC938RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode temp = root;
        TreeNode pop = null;
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    if (peek.val >= low && peek.val <= high) result.add(peek.val);
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    pop = stack.pop();
                }else {
                    if (peek.val >= low && peek.val <= high) result.add(peek.val);
                    temp = peek.right;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
