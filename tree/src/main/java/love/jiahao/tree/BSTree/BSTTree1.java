package love.jiahao.tree.BSTree;

/**
 * <big>二叉搜索树</big>
 * <p>BinarySearch Tree</p>
 * @author 13684
 * @date 2024/3/2
 */
public class BSTTree1<E> {
    public BSTNode<E> root; // 根节点

    /**
     * <h2>根据key查找值</h2>
     *
     * @param key 键
     * @return 值
     */
    public E get(int key) {
        BSTNode<E> temp = root;
        while (temp != null) {
            if (key > temp.key) {
                temp = temp.right;
            } else if (key < temp.key) {
                temp = temp.left;
            }else return temp.value;
        }
        return null;
    }

    // 树的节点
    public static class BSTNode<E>{
        // 键
        int key;
        // 值
        E value;
        // 左孩子
        BSTNode<E> left;
        // 右孩子
        BSTNode<E> right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, E value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, E value, BSTNode<E> left, BSTNode<E> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "BSTNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
