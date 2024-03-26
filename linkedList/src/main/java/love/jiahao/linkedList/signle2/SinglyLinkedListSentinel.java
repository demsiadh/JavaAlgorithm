package love.jiahao.linkedList.signle2;

import love.jiahao.linkedList.LC206ReserveLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    // 头节点，哨兵
    private final Node head = new Node(0, null);

    /**
     * 头插法,插入到第一个位置
     */
    public void addFirst(int value) {
        head.next = new Node(value, head.next);
    }

    /**
     * 尾部添加
     * @param value 要添加的节点值
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    /**
     * 往对应索引位置添加节点
     * @param index     索引
     * @param value     值
     */
    public void insert(int index, int value) {
        // 如果索引为0就直接添加头部
        if (index == 0) {
            this.addFirst(value);
            return;
        }
        // 查找要添加的节点的上一个节点
        Node node = this.findNode(index - 1);
        // 不为空就插入
        node.next = new Node(value, node.next);
    }

    /**
     * 删除第一个节点并返回该节点的值
     */
    public void removeFirst() {
        if (this.isEmpty()) throw new RuntimeException("链表为空!");
        head.next = head.next.next;
    }

    /**
     * 删除指定索引的节点
     * @param index 索引
     */
    public void remove(int index) {
        if (index == 0) {
            this.removeFirst();
            return;
        }
        // 找到前一个节点
        Node node = this.findNode(index - 1);
        if (node.next == null) throw new IllegalArgumentException("索引越界!");
        node.next = node.next.next;
    }

    /**
     * 找到最后的节点并返回
     * @return  最后的节点
     */
    private Node findLast() {
        if (isEmpty()) return head;
        Node temp = head.next;
        while (temp.next != null) temp = temp.next;
        return temp;
    }

    /**
     * 寻找链表中的节点，按索引寻找，实际并没有索引(内部使用)
     * @param index     索引
     * @return          对应节点
     */
    private Node findNode(int index) {
        if (isEmpty()) return head;
        int i = 0;
        for (Node temp = head.next; temp != null; temp = temp.next, i++){
            if (i == index) return temp;
        }
        throw new IllegalArgumentException("索引越界!");
    }

    /**
     * 返回对应索引位置的值
     * @param index 索引
     * @return      值
     */
    public int get(int index) {
        Node node = findNode(index);
        return node.value;
    }

    /**
     * 遍历所有节点(while)
     */
    public void loop(Consumer<Integer> consumer) {
        Node temp = head.next;
        while (temp != null) {
            consumer.accept(temp.value);
            temp = temp.next;
        }
    }

    /**
     * 遍历所有节点(for)
     * @param consumer 传入操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node temp = head.next; temp != null; temp = temp.next){
            consumer.accept(temp.value);
        }
    }

    /**
     * 递归打印
     */
    public void loop3(Consumer<Integer> before,
                      Consumer<Integer> after) {
        recursion(head.next, before, after);
    }

    /**
     * 递归方法
     */
    private void recursion(Node node, Consumer<Integer> before, Consumer<Integer> after) {
        if (node == null) return;
        before.accept(node.value);
        recursion(node.next, before, after);
        after.accept(node.value);
    }

    /**
     * 内部使用，判断链表是否为空
     * @return 链表是否为空
     */
    private boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 迭代器遍历
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node temp = head.next;

            @Override
            public boolean hasNext() { // 是否有下一个元素
                return temp != null;
            }

            @Override
            public Integer next() { // 返回当前元素的值，并指向下一个元素
                int value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    private static class Node {
        int value;
        Node next;
        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
