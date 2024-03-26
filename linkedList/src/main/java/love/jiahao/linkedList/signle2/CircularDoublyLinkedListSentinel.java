package love.jiahao.linkedList.signle2;

import java.util.Iterator;

/**
 * 环形双向链表
 */
public class CircularDoublyLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node temp = sentinel.next;

            @Override
            public boolean hasNext() {
                return temp != sentinel;
            }

            @Override
            public Integer next() {
                int value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;  // 上一个节点
        Node next;  // 下一个节点
        int value;  // 值

        public Node(int value, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
    private Node sentinel;
    {
        sentinel = new Node(0, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 头插法
     */
    public void addFirst(int value) {
        Node prev = sentinel;
        Node next = sentinel.next;
        Node node = new Node(value, prev, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 尾插法
     */
    public void addLast(int value) {
        Node next = sentinel;
        Node prev = sentinel.prev;
        Node node = new Node(value, prev, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        Node prev = sentinel;
        Node next = sentinel.next.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        Node prev = sentinel.prev.prev;
        Node next = sentinel;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 根据节点的值进行删除
     */
    public void removeByValue(int value) {
        Node node = findByValue(value);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 根据值寻找节点
     * @param value 值
     * @return      节点
     */
    private Node findByValue(int value) {
        for (Node temp = sentinel.next; temp != sentinel; temp = temp.next) {
            if (value == temp.value) return temp;
        }
        throw new IllegalArgumentException("没有值为" + value + "的节点");
    }
}
