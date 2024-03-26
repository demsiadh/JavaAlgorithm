package love.jiahao.tree.BSTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>二叉搜索树,key为泛型</big>
 * <p>BinarySearch Tree</p>
 *
 * @author 13684
 * @date 2024/3/2
 */
public class BSTTree2<E extends Comparable<E>, T> {
    public BSTNode<E, T> root; // 根节点


    /**
     * <h2>根据key查找值</h2>
     *
     * @param key 键
     * @return 值
     */
    public T get(E key) {
        if (key == null) throw new IllegalArgumentException("key not cannot be null!");
        BSTNode<E, T> temp = root;
        while (temp != null) {
            int i = key.compareTo(temp.key);
            if (i > 0) {
                temp = temp.right;
            } else if (i < 0) {
                temp = temp.left;
            } else return temp.value;
        }
        return null;
    }


    /**
     * <h2>查找最小的键对应的值</h2>
     *
     * @return 最小值
     */
    public T min() {
        return min(root);
    }

    /**
     * <h2>查找对应节点下的最小值</h2>
     *
     * @param root 根节点
     * @return 最小值
     */
    private T min(BSTNode<E, T> root) {
        if (root == null) return null;
        BSTNode<E, T> temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.value;
    }

    /**
     * <h2>查找最大的键对应的值</h2>
     *
     * @return 最大值
     */
    public T max() {
        return max(root);
    }

    /**
     * <h2>查找对应节点下的最大值</h2>
     *
     * @param root 根节点
     * @return 最大值
     */
    private T max(BSTNode<E, T> root) {
        if (root == null) return null;
        BSTNode<E, T> temp = root;
        while (temp.right != null) temp = temp.right;
        return temp.value;
    }

    /**
     * <h2>添加键值对</h2>
     *
     * @param key   键
     * @param value 值
     */
    public void put(E key, T value) {
        if (key == null) throw new IllegalArgumentException("key not cannot be null!");
        // 树为空的情况
        if (isEmpty()) root = new BSTNode<>(key, value);
        BSTNode<E, T> temp = root;

        // 用于记录temp为null的最后一个节点,刚好作为新增节点的父节点
        BSTNode<E, T> parent = null;
        while (temp != null) {
            parent = temp;
            int i = key.compareTo(temp.key);
            if (i > 0) {
                temp = temp.right;
            } else if (i < 0) {
                temp = temp.left;
            } else {
                // 1. 树中有 更新
                temp.value = value;
                return;
            }
        }

        // 2. 树中无 新增
        // 判断为左节点还是右节点
        int j = parent.key.compareTo(key);
        if (j > 0) {
            parent.left = new BSTNode<>(key, value);
        } else {
            parent.right = new BSTNode<>(key, value);
        }

    }

    /**
     * <h2>查找键的前区值</h2>
     * <p>就是排序后当前值的前一个</p>
     *
     * @param key 键
     * @return 值
     */
    public T preValue(E key) {
        if (key == null) throw new IllegalArgumentException("key not cannot be null!");
        BSTNode<E, T> leftParent = null;
        // 1.首先找到当前节点
        BSTNode<E, T> temp = root;
        while (temp != null) {
            int i = key.compareTo(temp.key);
            if (i > 0) {
                leftParent = temp;
                temp = temp.right;
            } else if (i < 0) {
                temp = temp.left;
            } else {
                break;
            }
        }
        // 2.如果没有找到节点
        if (temp == null) return null;

        // 3.找到节点
        // 3.1当前节点有左子树（只需要找到左子树的最大值就是前驱值）
        if (temp.left != null) {
            return max(temp.left);
        }
        // 3.2没有左子树需要找当前节点距离最近的自左而来的祖先
        if (leftParent != null) return leftParent.value;
        return null;
    }

    /**
     * <h2>寻找当前节点的后任节点</h2>
     * <li>就是排完序当前节点的后一位</li>
     *
     * @param key 节点的键
     * @return 后任节点的值
     */
    public T postValue(E key) {
        // 1.排除非法参数
        if (key == null) throw new IllegalArgumentException("key not cannot be null!");
        BSTNode<E, T> temp = root;
        BSTNode<E, T> rightParent = null;
        while (temp != null) {
            int i = key.compareTo(temp.key);
            if (i > 0) {
                temp = temp.right;
            } else if (i < 0) {
                rightParent = temp;
                temp = temp.left;
            } else break;
        }
        // 2.如果没有找到对应节点
        if (temp == null) return null;

        // 3.当前节点是否有右子树
        // 3.1如果有右子树则右子树的最小值就是后任值
        if (temp.right != null) {
            return min(temp.right);
        }
        // 3.2如果没有右子树则是距离最近的自右而来的祖先节点
        if (rightParent != null) return rightParent.value;
        return null;
    }

    /**
     * <h2>根据键删除值</h2>
     *
     * @param key 要删除的键
     * @return 被删除的值
     */
    public T delete(E key) {
        if (key == null) throw new IllegalArgumentException("key not cannot be null!");
        // 1.找到要删除的节点
        BSTNode<E, T> temp = root;
        BSTNode<E, T> parent = null;
        // 1.1如果节点为空就返回为空
        while (temp != null) {
            int i = key.compareTo(temp.key);
            if (i > 0) {
                parent = temp;
                temp = temp.right;
            } else if (i < 0) {
                parent = temp;
                temp = temp.left;
            } else break;
        }
        if (temp == null) return null;
        // 2.删除的节点如果没有左孩子，将右孩子托孤给Parent
        if (temp.left == null) {
            shift(parent, temp, temp.right);
        } else if (temp.right == null) {
            // 3.删除的节点没有右孩子有左孩子
            shift(parent, temp, temp.left);
        }else {
            // 4.删除的节点既有左孩子又有右孩子
            // 4.1被删除的节点寻找后继
            BSTNode<E, T> post = temp.right; // 后继节点
            BSTNode<E, T> postParent = temp; // 后继节点的父节点
            while (post.left != null) {
                postParent = post;
                post = post.left;
            }
            // 4.2判断后继节点和删除节点是否相邻
            // 4.2.1 不相邻
            if (temp != postParent) {
                // 托孤
                shift(postParent, post, post.right); // 由于后继节点的特性只有右孩子
                post.right = temp.right;
            }
            // 4.3 后继取代被删除节点
            shift(parent, temp, post);
            post.left = temp.left;

        }
        return temp.value;
    }

    /**
     * <h2>托孤方法，用来处理被删除节点只有一个孩子的情况</h2>
     *
     * @param parent 父节点
     * @param node 当前节点（被删除节点）
     * @param child 唯一的子节点
     */
    private void shift(BSTNode<E, T> parent, BSTNode<E, T> node, BSTNode<E, T> child) {
        if (parent == null) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        }else {
            parent.right = child;
        }
    }

    /**
     * <h2>范围查询比key小的值</h2>
     *
     * @param key 键
     * @return 比键小的值
     */
    public List<T> less(E key) {
        if (isEmpty()) return null;
        List<T> result = new ArrayList<>();
        LinkedList<BSTNode<E, T>> stack = new LinkedList<>();
        BSTNode<E, T> temp = root;
        BSTNode<E, T> pop = null;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                BSTNode<E, T> peek = stack.peek();
                if (peek.key.equals(key)) break;
                if (peek.right == null) {
                    // 没有右子树
                    result.add(peek.value);
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    // 右子树已经处理
                    pop = stack.pop();
                }else {
                    // 准备处理右子树
                    result.add(peek.value);
                    temp = peek.right;
                }
            }
        }
        return result;
    }

    /**
     * <h2>查找比当前key大的值</h2>
     *
     * @param key 键
     * @return 比key大的值
     */
    public List<T> greater(E key) {
//        if (isEmpty()) return null;
//        List<T> result = new ArrayList<>();
//        LinkedList<BSTNode<E, T>> stack = new LinkedList<>();
//        BSTNode<E, T> temp = root;
//        BSTNode<E, T> pop = null;
//        while (temp != null || !stack.isEmpty()) {
//            if (temp != null) {
//                stack.push(temp);
//                temp = temp.left;
//            }else {
//                BSTNode<E, T> peek = stack.peek();
//                if (peek.right == null) {
//                    // 没有右子树
//                    if (peek.key.compareTo(key) > 0) result.add(peek.value);
//                    pop = stack.pop();
//                } else if (peek.right == pop) {
//                    // 右子树已经处理
//                    pop = stack.pop();
//                }else {
//                    // 准备处理右子树
//                    if (peek.key.compareTo(key) > 0) result.add(peek.value);
//                    temp = peek.right;
//                }
//            }
//        }
//        return result;
        // 反转中序遍历
        if (isEmpty()) return null;
        List<T> result = new ArrayList<>();
        LinkedList<BSTNode<E, T>> stack = new LinkedList<>();
        BSTNode<E, T> temp = root;
        BSTNode<E, T> pop = null;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.right;
            }else {
                BSTNode<E, T> peek = stack.peek();
                if (peek.key.compareTo(key) <= 0) break;
                if (peek.left == null) {
                    // 没有左子树
                    if (peek.key.compareTo(key) > 0) result.add(peek.value);
                    pop = stack.pop();
                } else if (peek.left == pop) {
                    // 左子树已经处理
                    pop = stack.pop();
                }else {
                    // 准备处理左子树
                    if (peek.key.compareTo(key) > 0) result.add(peek.value);
                    temp = peek.left;
                }
            }
        }
        return result;
    }

    /**
     * <h2>查找在两个键之间的值</h2>
     *
     * @param min 下限
     * @param max 上限
     * @return 两个键之间的值
     */
    public List<T> between(E min, E max) {
        if (isEmpty()) return null;
        List<T> result = new ArrayList<>();
        LinkedList<BSTNode<E, T>> stack = new LinkedList<>();
        BSTNode<E, T> temp = root;
        BSTNode<E, T> pop = null;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                BSTNode<E, T> peek = stack.peek();
                if (peek.key.compareTo(max) > 0) break;
                if (peek.right == null) {
                    // 没有右子树
                    if (peek.key.compareTo(min) >= 0 && peek.key.compareTo(max) <= 0) result.add(peek.value);
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    // 右子树已经处理
                    pop = stack.pop();
                }else {
                    // 准备处理右子树
                    if (peek.key.compareTo(min) >= 0 && peek.key.compareTo(max) <= 0) result.add(peek.value);
                    temp = peek.right;
                }
            }
        }
        return result;
    }

    /**
     * <h2>内部方法，判断树是否为空</h2>
     *
     * @return 是否为空
     */
    private boolean isEmpty() {
        return root == null;
    }

    // 树的节点
    public static class BSTNode<E, T> {
        // 键
        E key;
        // 值
        T value;
        // 左孩子
        BSTNode<E, T> left;
        // 右孩子
        BSTNode<E, T> right;

        public BSTNode(E key) {
            this.key = key;
        }

        public BSTNode(E key, T value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(E key, T value, BSTNode<E, T> left, BSTNode<E, T> right) {
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
