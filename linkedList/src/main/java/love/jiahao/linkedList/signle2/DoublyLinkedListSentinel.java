package love.jiahao.linkedList.signle2;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
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
    private Node head;
    private Node tail;
    {
        head = new Node(0, null, null);
        tail = new Node(1, null, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 头插法
     * @param value 需要插入的值
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 尾插法
     * @param value 插入的值
     */
    public void addLast(int value) {
        Node prev = tail.prev;
        Node node = new Node(value, prev, tail);
        prev.next = node;
        tail.prev = node;
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除最后一个节点
     */
    public void removeLast() {
        Node prev = tail.prev.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     * 根据索引删除节点
     * @param index 索引
     */
    public void remove(int index) {
        Node node = findNode(index);
        Node prev = node.prev;
        Node next = node.next;
        // 进行删除
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 根据索引插入节点
     * @param index 索引
     * @param value 节点值
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        Node next = prev.next;
        // 加入新节点
        Node node = new Node(value, prev, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 根据索引找节点
     * @param index 索引
     * @return      节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node temp = head; temp != tail; temp = temp.next, i++) {
            if (i == index) return temp;
        }
        throw new IllegalArgumentException("参数不合法");
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node temp = head.next;
            @Override
            public boolean hasNext() {
                return temp.next != null;
            }

            @Override
            public Integer next() {
                int value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }
}
