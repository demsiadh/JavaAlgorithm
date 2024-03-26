package love.jiahao.tree.bTree;

import java.util.Arrays;

/**
 * <big>b树实现</big>
 *
 * @author 13684
 * @date 2024/3/8
 */
public class BTree {

    public Node root; // 根节点
    public int t; // 最小度数
    final int MIN_KEY_NUMBER; // 最小key的数量
    final int MAX_KEY_NUMBER; // 最大key的数量

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(root.keys, 0, root.size));
    }

    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MIN_KEY_NUMBER = t - 1;
        MAX_KEY_NUMBER = 2 * t - 1;
    }

    // 判断节点是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    // 添加 当前设计中并没有value所以不考虑
    public void put(int key) {
        doPut(root, key, null, 0);
    }

    /**
     * <p>递归函数，用于添加节点的key</p>
     *
     * @param node 从哪个节点开始添加
     * @param key  添加的key
     */
    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.size) {
            if (node.keys[i] == key) {
                // 更新
                return;
            }
            if (node.keys[i] > key) {
                break; // 找到了要插入的位置
            }
            i++;
        }

        // 判断是否为叶子节点
        if (node.leaf) {
            node.insertKey(key, i);
        } else {
            doPut(node.nodes[i], key, node, i);
        }

        if (node.size >= MAX_KEY_NUMBER) {
            split(node, parent, index);
        }
    }


    /**
     * <p>分裂方法</p>
     *
     * @param left   要分裂的节点
     * @param parent 分裂节点的父节点
     * @param index  分裂节点为父节点孩子的索引
     */
    public void split(Node left, Node parent, int index) {
        // 1.如果需要分裂的是根节点
        if (left == this.root) {
            Node newRoot = new Node(t);
            newRoot.leaf = false;
            newRoot.insertNode(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }

        // 2.创建右孩子
        Node right = new Node(t);
        // 将要分裂的孩子的较大值拷贝给右孩子
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);

        // 3.如果分裂的是非叶子节点 就同时拷贝孩子过去就行了
        if (!left.leaf) {
            System.arraycopy(left.nodes, t, right.nodes, 0, t);
        }

        // 右孩子与要分裂节点平级
        right.leaf = left.leaf;
        // 右孩子的有效key数
        right.size = t - 1;
        // 父亲节点中插入要分裂节点的中间key
        parent.insertKey(left.keys[t - 1], index);
        // 左孩子的有效key数
        left.size = t - 1;
        // 父亲节点插入右孩子
        parent.insertNode(right, index + 1);
    }

    // 删除方法
    public void remove(int key) {
        doRemove(this.root, key, null, 0);
    }

    //                  从哪个节点开始删除 要删除的key
    private void doRemove(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.size) {
            // 大于代表要往子节点找，等于代表就在当前节点
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }
        // 1.判断是否是叶子节点
        if (node.leaf) {
            if (!(i < node.size && node.keys[i] == key)) {
                // 1.1当前节点是叶子节点，没找到
                return;
            } else {
                // 1.2当前节点是叶子节点，找到了
                node.removeKey(i);
            }
        } else {
            if (!(i < node.size && node.keys[i] == key)) {
                // 1.3当前节点是非叶子节点，没找到
                doRemove(node.nodes[i], key, node, i);
            } else {
                // 1.4当前节点是非叶子节点，找到了
                // 1.4.1 找到后继节点
                Node s = node.nodes[i + 1];
                while (!s.leaf) {
                    s = s.nodes[0];
                }
                int skey = s.keys[0];
                // 1.4.2替换待删除的key
                node.keys[i] = skey;
                // 1.4.3 删除后继节点key
                doRemove(node.nodes[i + 1], skey, node, i + 1);
            }
        }

        if (node.size < MIN_KEY_NUMBER) {
            // 1.5 删除后key数目小于下限
            // 1.6 删除节点为根节点
            balance(parent, node, index);
        }
    }

    // 平衡方法             父节点       要平衡的节点 是父节点的第几个孩子
    private void balance(Node parent, Node node, int index) {
        // 1.如果是根节点
        if (node == this.root) {
            if (root.size == 0 && root.nodes[0] != null) {
                root = root.nodes[0];
            }
            return;
        }
        Node left = parent.childLeftSibling(index);
        Node right = parent.chileRightSibling(index);
        // 2.左边富裕，右旋
        if (left != null && left.size > MIN_KEY_NUMBER) {
            // 将父亲节点对应的元素旋转到平衡节点
            node.insertKey(parent.keys[index - 1], 0);

            // 如果左节点不是叶子节点，则将其最大的孩子过继给平衡节点
            if (!left.leaf) {
                node.insertNode(left.removeRightmostChild(), 0);
            }
            // 父节点对应的元素改为左节点最大的key
            parent.keys[index - 1] = left.removeRightmostKey();
            return;
        }
        // 3.右边富裕，左旋
        if (right != null && right.size > MIN_KEY_NUMBER){
            node.insertKey(parent.keys[index], node.size);

            if (!right.leaf) {
                node.insertNode(right.removeLeftmostChild(), node.size + 1);
            }
            parent.keys[index] = right.removeLeftmostKey();
            return;
        }

        // 4.都不够，合并
        if (left != null) {
            // 4.1有左兄弟，向左兄弟合并
            // 删除需要平衡的节点
            parent.removeChild(index);
            // 左兄弟加入父节点的key
            left.insertKey(parent.removeKey(index - 1), left.size);
            // 将平衡节点补给左兄弟
            node.moveToLeft(left);
        }else {
            // 4.2向自己合并
            Node removeChild = parent.removeChild(index + 1);
            node.insertKey(parent.removeKey(index), node.size);
            removeChild.moveToLeft(node);
        }
    }


    public static class Node {
        public int[] keys; // 键
        public Node[] nodes; // 孩子
        public int size; // 有效值的个数
        public boolean leaf = true; // 是否为叶子节点
        public int t; // 最小度数 （最小的孩子数）

        public Node(int t) {
            this.t = t;
            this.keys = new int[2 * t - 1];
            this.nodes = new Node[2 * t];   // 孩子数是最小度数的两倍
        }

        @Override
        public String toString() {
            // 打印出节点中有效的key
            return Arrays.toString(Arrays.copyOfRange(keys, 0, size));
        }

        // 获取指定键的节点
        Node get(int key) {
            int i = 0;
            while (i < size) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此说明 i == size 或者 keys[i] > key
            // 1.如果为叶子节点则说明树中不存在查找值
            if (this.leaf) {
                return null;
            }

            // 2.如果为非叶子节点则向下查找
            return this.nodes[i].get(key);
        }

        // 向keys中指定索引index插入key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, size - index);
            keys[index] = key;
            size++;
        }

        // 向子节点数组中指定索引index插入child
        void insertNode(Node node, int index) {
            System.arraycopy(nodes, index, nodes, index + 1, size - index);
            nodes[index] = node;
        }


        // 移除指定index的key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --size - index);
            return t;
        }

        // 移除最左边的key
        int removeLeftmostKey() {
            return removeKey(0);
        }

        // 移除最右边的key
        int removeRightmostKey() {
            return removeKey(size - 1);
        }

        // 移除指定index处的节点
        Node removeChild(int index) {
            Node node = nodes[index];
            System.arraycopy(nodes, index + 1, nodes, index, size - index);
            nodes[size] = null;
            return node;
        }

        // 移除最左边的孩子
        Node removeLeftmostChild() {
            return removeChild(0);
        }

        // 移除最右边的孩子
        Node removeRightmostChild() {
            return removeChild(size);
        }

        // index处孩子的左边兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? nodes[index - 1] : null;
        }

        // index处孩子的右边兄弟
        Node chileRightSibling(int index) {
            return index == size ? null : nodes[index + 1];
        }

        // 复制当前节点的所有key和child到target(不要覆盖)
        void moveToLeft(Node target) {
            int start = target.size;
            if (!this.leaf) {
                for (int i = 0; i <= size; i++) {
                    target.nodes[start + 1] = nodes[i];
                }
            }

            for (int i = 0; i < size; i++) {
                target.keys[target.size++] = keys[i];
            }
        }
    }
}
