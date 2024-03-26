package love.jiahao.tree.AVLTree;

import love.jiahao.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>AVL树-自平衡二叉搜索树</big>
 *
 * @author 13684
 * @date 2024/3/5
 */
public class AVLTree1 {
    public static void main(String[] args) {
        /*
            2
          1   3
             4  5
         */
        AVLTree1 tree1 = new AVLTree1(new TreeNode(1, "man1"));
        tree1.putNode(2, "man2");
        tree1.putNode(3, "man3");
    }

    private TreeNode root;

    public AVLTree1(TreeNode root) {
        this.root = root;
    }

    private int height(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    // 更新节点的高度（新增 删除 旋转的时候更新
    private void updateHeight(TreeNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    // 平衡因子
    private int bf(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    /*
    四种失衡情况
    1. LL 左左 失衡节点左边高，并且失衡节点的左孩子左边高 -> 一次右旋
    2. LR 左右 失衡节点左边高 但是失衡节点的左孩子右边高 -> 左子树向左旋转 失衡节点向右旋转
    3. RR 右右 失衡节点右边高 并且失衡节点的右孩子右边高 -> 一次左旋
    4. RL 右左 失衡节点右边高，并且失衡节点的右孩子左边高 -> 右子树向右旋转 失衡节点向左旋转
     */

    /**
     * <h2>右旋方法</h2>
     *
     * @param root 要右旋的节点
     * @return 新的根节点
     */
    private TreeNode rightRotate(TreeNode root) {
        // 左孩子
        TreeNode rootLeft = root.left;
        // 左孩子的右孩子
        // 细节：不用考虑rootLeft为空，因为既然要右旋肯定是左边高，一定有左孩子
        TreeNode rootLeftRight = rootLeft.right;
//        if (root == this.root) {
//            this.root = rootLeft;
//        }
        // 上位
        rootLeft.right = root;

        // 换爹（rootLeft的右孩子肯定比rootLeft要大，所以要在新的根节点右边但是肯定比老的右子树小，所以挂在老的根节点的左边）
        root.left = rootLeftRight;
        // 更新高度
        // 细节：先更新原来的根节点，因为下面的节点不更新高度，上面的更新也是错的，这里其他节点并不用更新
        updateHeight(root); // 原来的根节点
        updateHeight(rootLeft); // 现在的根节点
        return rootLeft;
    }

    private TreeNode leftRotate(TreeNode root) {
        TreeNode rootRight = root.right;
        TreeNode rootRightLeft = rootRight.left;
//        if (root == this.root) this.root = rootRight;

        rootRight.left = root;
        root.right = rootRightLeft;
        updateHeight(root);
        updateHeight(rootRight);
        return rootRight;
    }

    /**
     * <h2>左右旋->先旋转左子树，然后旋转根节点</h2>
     *
     * @param root 失衡节点
     * @return 旋转后的根节点
     */
    private TreeNode leftRightRotate(TreeNode root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    /**
     * <h2>右左旋->先旋转右子树，然后旋转根节点</h2>
     *
     * @param root 失衡节点
     * @return 旋转后的根节点
     */
    private TreeNode rightLeftRotate(TreeNode root) {
        root.right = rightRotate(root.right);
        return leftRightRotate(root);
    }

    /**
     * <h2>检查并平衡当前二叉树</h2>
     *
     * @param root 根节点
     * @return 平衡后的根节点
     */
    private TreeNode balance(TreeNode root) {
        if (root == null) return null;
        int bf = bf(root);
        // 添加等于0是为了防止右节点删除后，根节点失衡，需要右旋的情况
        if (bf > 1 && bf(root.left) >= 0) { // LL
            return rightRotate(root);
        } else if (bf > 1 && bf(root.left) < 0) { // LR
            return leftRightRotate(root);
        } else if (bf < -1 && bf(root.right) > 0) { // RL
            return rightLeftRotate(root);
        } else if (bf < -1 && bf(root.right) <= 0) { // RR
            return leftRotate(root);
        }
        return root;
    }

    /**
     * <h2>新增节点（同时要保持高度和平衡）</h2>
     * <li>自己写的正确性不知道</li>
     *
     * @param key   键
     * @param value 值
     */
    public void putNode(int key, Object value) {
        // 树为空
        if (root == null) root = new TreeNode(key, value);
        TreeNode temp = root;
        List<TreeNode> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp);
            if (key > temp.key) {
                temp = temp.right;
            } else if (key < temp.key) {
                temp = temp.left;
            } else {
                // 树中有直接更新
                temp.value = value;
                return;
            }
        }

        // 2.树中无则新增
        TreeNode parent = list.get(list.size() - 1);
        if (key > parent.key) {
            parent.right = new TreeNode(key, value);
        } else {
            parent.left = new TreeNode(key, value);
        }

        // 3.更新高度
        for (int i = list.size() - 1; i >= 0; i--) {
            updateHeight(list.get(i));
            balance(list.get(i));
        }
    }

    /**
     * <h2>删除节点</h2>
     * <li>自己写的,正确性不定</li>
     *
     * @param key 键
     */
    public void remove(int key) {
        if (root == null) return;
        TreeNode temp = root;
        List<TreeNode> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp);
            if (key > temp.key) {
                temp = temp.right;
            } else if (key < temp.key) {
                temp = temp.left;
            } else break;
        }

        // 如果没找到
        if (temp == null) return;
        TreeNode parent = list.get(list.size() - 2);
        // 2.删除节点如果没有左孩子，将右孩子托孤给父亲节点
        if (temp.left == null) {
            shift(parent, temp, temp.right);
        } else if (temp.right == null) {
            // 3.删除节点没有右孩子
            shift(parent, temp, temp.left);
        } else {
            // 4.删除节点既有右孩子又有左孩子
            // 4.1被删节点寻找后继
            TreeNode post = temp.right;
            TreeNode postParent = temp; // 后继节点的父节点
            while (post.left != null) {
                postParent = post;
                post = post.left;
            }

            // 4.2判断是否相邻
            if (temp != postParent) {
                // 托孤
                shift(postParent, post, post.right);
                post.right = temp.right;
            }

            // 4.3后继节点取代删除节点
            shift(parent, temp, post);
            post.left = temp.left;
        }

        // 5.保持平衡
        for (int i = list.size() - 2; i >= 0; i--) {
            updateHeight(list.get(i));
            balance(list.get(i));
        }
    }

    private void shift(TreeNode parent, TreeNode node, TreeNode child) {
        if (parent == null) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    private static class TreeNode {
        int key;
        Object value;
        TreeNode left;
        TreeNode right;
        int height = 1;

        public TreeNode(int key) {
            this.key = key;
        }

        public TreeNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public TreeNode(int key, Object value, TreeNode left, TreeNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
