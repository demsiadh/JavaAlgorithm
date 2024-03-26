package love.jiahao.tree.redBlack;

import static love.jiahao.tree.redBlack.RedBlackTree.Color.BLACK;
import static love.jiahao.tree.redBlack.RedBlackTree.Color.RED;

/**
 * <big>红黑树</big>
 *
 * @author 13684
 * @date 2024/3/6
 */
public class RedBlackTree {
    Node root;
    /**
     * <h2>判断节点是否为红色（定义在外面是因为节点为null就是黑色，而null不能获取属性）</h2>
     *
     * @param node 节点
     * @return 是否为红色
     */
    boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    boolean isBlack(Node node) {
        return !isRed(node);
    }

    private void rightRotate(Node root) {
        Node parent = root.parent;  // 父节点
        Node left = root.left;  // 左孩子
        Node leftRight = left.right; // 左孩子的右孩子

        left.right = root; // 将节点作为左孩子的右孩子
        left.parent = parent; // 将节点的父亲作为左孩子的父亲

        root.left = leftRight; // 将左孩子的右孩子交给原来的节点
        root.parent = left; // 将节点的父亲修改为左孩子

        if (leftRight != null) {  // 如果左孩子的右孩子为空则不用修改父指针
            leftRight.parent = root;
        }
        if (parent != null) {       // 如果节点有父亲 将左孩子交给他
            if (root.isLeftChild()) {
                parent.left = left;
            }else {
                parent.right = left;
            }
        } else {
            this.root = left;   // 如果没有父亲则证明节点是根节点，所以将根节点修改为左孩子
        }
    }

    private void leftRotate(Node root) {
        Node parent = root.parent;  // 父节点
        Node right = root.right;  // 右孩子
        Node rightLeft = right.left; // 右孩子的左孩子

        right.left = root;
        right.parent = parent;

        root.right = rightLeft;
        root.parent = right;

        if (rightLeft != null) {
            rightLeft.parent = root;
        }

        if (parent != null) {
            if (root.isLeftChild()) {
                parent.left = right;
            }else {
                parent.right = right;
            }
        }else {
            this.root = right;
        }
    }

    public void put(int key, Object value) {
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            parent = temp;
            if (key > temp.key) {
                temp = temp.right;
            } else if (key < temp.key) {
                temp = temp.left;
            }else {
                temp.value = value;
                return;
            }
        }

        Node inserted = new Node(key, value);
        if (parent == null) {
            this.root = inserted;
        } else if (key > parent.key) {
            parent.right = inserted;
        }else {
            parent.left = inserted;
        }
        inserted.parent = parent;

        fixRedRed(inserted);

    }

    // 修复红红相邻，因为红黑树性质红红不能相邻
    private void fixRedRed(Node node) {
        if (node == this.root) {
            // 1.插入节点为根节点，改变颜色为黑色
            node.color = BLACK;
            return;
        }

        Node parent = node.parent;
        if (isBlack(parent)) {
            // 2.插入节点的父节点为黑色，无需更改
            return;
        }


        // 3.插入节点的父节点为红色，触发红红相邻
        // 3.1叔叔为红色
        // 这种情况将父亲，叔叔变黑，祖父变红，对祖父进行递归处理
        Node uncle = node.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = BLACK;
            assert uncle != null;
            uncle.color = BLACK;
            grandparent.color = RED;
            // 递归处理（因为祖父变红后可能会触发红红相邻）
            fixRedRed(grandparent);
            return;
        }

        // 3.2叔叔为黑色
        // 3.2.1父亲为左孩子，插入节点也是左孩子，此时LL不平衡 需要对祖父进行右旋
        //      同时将父亲变为黑色，祖父变为红色
        if (parent.isLeftChild() && node.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        // 3.2.2父亲为左孩子，插入节点为右孩子，此时LR不平衡，首先对父亲进行一次左旋
        //      同时将插入节点变为黑色（因为旋转上去了），祖父变为红色，然后对祖父进行右旋
        }else if (parent.isLeftChild())  {
            leftRotate(parent);
            node.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        // 3.2.3父亲为右孩子，插入节点为右孩子，此时RR不平衡 对祖父进行左旋
        //      同时将父亲变为黑色，祖父变为红色
        } else if (!node.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        // 3.2.4父亲为右孩子，插入节点为左孩子，此时RL不平衡 首先对父亲进行右旋
        //      同时将插入节点变为黑色，祖父变为红色，再对祖父进行左旋
        }else {
            rightRotate(parent);
            node.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }

    // 移除节点
    public void remove(int key) {
        Node deleted = findDeleted(key);
        if (deleted == null) return;
        doRemove(deleted);
    }

    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            if (deleted == root) {
                root = null;
            }else {
                // 删除的是黑色节点会失衡需要调整
                if (isBlack(deleted)) {
                    fixDoubleBlack(deleted);
                }else {
                    // 删除的是红色节点，不需要平衡
                }
                if (deleted.isLeftChild()) {
                    parent.left = null;
                }else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
             return;
         }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            }else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                }else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;

                if (isBlack(deleted) && isBlack(replaced)) {
                    // 删除的是黑，剩下的也是黑
                    fixDoubleBlack(replaced);
                }else {
                    // 删除的是黑，剩下的是红（因为红黑树的性质，红色节点不可能只有一个孩子，所以删除的是黑色）
                    replaced.color = BLACK;
                }
            }
            return;
        }

        // 两个孩子
        // 这里换种方法处理，直接交换删除节点和后继节点的值和key，随后删除后继节点即可
        deleted.key = replaced.key;
        deleted.value =  replaced.value;

        // 递归调用删除后继节点
        doRemove(replaced);

    }
    // 处理双黑的情况
    private void fixDoubleBlack(Node node) {
        if (node == root) return;
        Node parent = node.parent;
        Node brother = node.brother();
        if (isRed(brother)) {
            // 1.被调整的节点的兄弟为红，此时两个侄子一定为黑
            if (node.isLeftChild()) {
                leftRotate(parent);
            }else rightRotate(parent);
            parent.color = RED;
            assert brother != null;
            brother.color = BLACK;
            fixDoubleBlack(node);
            return;
        }
        if (brother != null) {
            // 2.被调整节点的兄弟是黑色，两个侄子都为黑色
            if (isBlack(brother.left) && isBlack(brother.right)) {
                brother.color = RED;
                if (parent.color == RED) {
                    parent.color = BLACK;
                }else {
                    fixDoubleBlack(parent);
                }
            }else {
                // 3.兄弟是黑色，侄子至少有一个是红色
                // 3.1 LL 兄弟是左孩子 左侄子是红
                 if (brother.isLeftChild() && isRed(brother.left)) {
                     rightRotate(parent);
                     brother.left.color = BLACK;
                     brother.color = parent.color;
                 } else if (brother.isLeftChild() && isRed(brother.right)) {
                     brother.right.color = parent.color;
                     leftRotate(brother);
                     rightRotate(parent);
                     // RL
                 } else if (!brother.isLeftChild() && isRed(brother.left)) {
                    brother.left.color = BLACK;
                     rightRotate(brother);
                    leftRotate(parent);
                 } else if (!brother.isLeftChild() && isRed(brother.right)) {
                     leftRotate(parent);
                     brother.right.color = BLACK;
                     brother.color = parent.color;
                 }
                parent.color =  BLACK;


            }
        }else fixDoubleBlack(parent);


    }

    // 查找删除节点
    private Node findDeleted(int key) {
        Node temp = root;
        while (temp != null) {
            if (key > temp.key) {
                temp = temp.right;
            } else if (key < temp.key) {
                temp = temp.left;
            }else {
                return temp;
            }
        }
        return null;
    }
    // 查找被删节点的代替节点
    private Node findReplaced(Node node) {
        // 1.没有孩子
        if (node.left == null && node.right == null) {
            return null;
        // 2.只有左孩子
        } else if (node.left != null && node.right == null) {
            return node.left;
        // 3.只有右孩子
        } else if (node.left == null) {
            return node.right;
        // 4.两个孩子都有 找后继节点
        }else {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
    }

    enum Color{
        RED, BLACK;
    }

    private static class Node{
        int key;
        Object value;
        Node parent;
        Node left;
        Node right;
        Color color = RED;

        public Node(int key, Object value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        // 是否为左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        // 叔叔(父亲的兄弟)
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            }else {
                return parent.parent.left;
            }
        }

        // 兄弟
        Node brother() {
            if (parent == null) return null;
            if (this.isLeftChild()) {
                return parent.right;
            }else {
                return parent.left;
            }
        }
    }
}
