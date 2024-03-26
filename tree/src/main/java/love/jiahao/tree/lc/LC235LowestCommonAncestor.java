package love.jiahao.tree.lc;

/**
 * <big>力扣235题-二叉搜索树的最近公共祖先</big>
 *
 * @author 13684
 * @date 2024/3/4
 */
public class LC235LowestCommonAncestor {
    // 节点如果在两侧当前节点就是最近公共祖先
    /*
              6
           /    \
          2      8
         / \    /  \
        0   4  7   9
           / \
          3   5
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode temp = root;
        while ((p.val < temp.val && q.val < temp.val) || (p.val > temp.val && q.val > temp.val)) {
            // 都在节点左侧
            if (p.val < temp.val) {
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        // 最后的当前节点就是最近公共祖先
        return temp;
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
