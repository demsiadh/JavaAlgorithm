package love.jiahao.queue.leetcode;


/**
 * <big>力扣23题合并多个有序链表（优先级队列实现）</big>
 * <p>这里不使用堆存储全部节点再陆续取出，是因为这种方式比较占用空间</p>
 * <p>因为每个链表都是有序的，所以可以使用这种方法，节省空间占用</p>
 * @author 13684
 * @date 2024/2/27
 */
public class LC23MergeKLists {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                ListNode.of(1, 3, 5),
                ListNode.of(2, 2, 6),
                ListNode.of(4, 5, 6)
        };
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1.将链表的头节点加入小顶堆
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        // 2.不断从堆顶移除最小元素，加入新链表
        // 2.1哨兵节点
        ListNode sentinel = new ListNode(0, null);
        // 2.2临时节点(用于记住当前尾部)
        ListNode temp = sentinel;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            temp.next = node;
            temp = node;
            // 添加新的节点进来
            if (node.next != null){
                heap.offer(node.next);
            }
        }

        return sentinel.next;
    }


    // 小顶堆
    static class MinHeap{
        ListNode[] array;
        int size;

        MinHeap(int capacity) {
            array = new ListNode[capacity];
        }

        /**
         * <p>先插入到最后面，然后与父节点的优先级进行比较，如果优先级较低则让原来的父节点跑到下面</p>
         * <p>保持小顶堆的特性</p>
         * @param value 待插入值
         * @return 插入结果
         */
        public boolean offer(ListNode value) {
            if (isFull()) return false;
            insert(value);
            return true;
        }

        private void insert(ListNode value) {
            // 子节点索引位置
            int child = size++;
            // 父节点
            int parent = (child - 1) / 2;
            // 判断新插入的值的优先级和原来的父节点的优先级哪个小
            while (child > 0 && value.val < array[parent].val) {
                // 如果小于父节点的优先级则交换位置
                array[child] = array[parent];
                // 新的子节点和父节点
                child = parent;
                parent = (child - 1) / 2;
            }
            // 找到位置时直接插入
            array[child] = value;
        }

        /**
         * <p>首先交换堆顶和堆底元素。size--</p>
         * <p>将交换上去的元素与左右孩子对比，与较小的交换</p>
         * <p>直到父元素小于孩子或者没孩子</p>
         * @return 取出结果
         */
        @SuppressWarnings("all")
        public ListNode poll() {
            if (isEmpty()) return null;
            ListNode result = array[0];
            array[0] = array[--size];
            array[size] = null;
            int parent = 0;
            int leftChild = 1;
            int rightChild = 2;
            int max = parent; // 假设父节点优先级最低
            while (leftChild <= size - 1) {
                if (array[leftChild].val < array[max].val) {
                    max = leftChild;
                }
                if (rightChild <= size - 1 && array[rightChild].val < array[max].val) {
                    max = rightChild;
                }

                if (max != parent) {
                    ListNode e = array[max];
                    array[max] = array[parent];
                    array[parent] = e;
                } else {
                    break;
                }
                parent = max;
                leftChild = parent * 2 + 1;
                rightChild = leftChild + 1;
            }

            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }
    // 节点类
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public static ListNode of(int... elements) {
            if (elements.length == 0) {
                return null;
            }
            ListNode p = null;
            for (int i = elements.length - 1; i >= 0; i--) {
                p = new ListNode(elements[i], p);
            }
            return p;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[");
            ListNode p = this;
            while (p != null) {
                sb.append(p.val);
                if (p.next != null) {
                    sb.append(",");
                }
                p = p.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
