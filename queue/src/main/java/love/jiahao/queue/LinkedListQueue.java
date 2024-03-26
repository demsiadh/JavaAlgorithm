package love.jiahao.queue;

import java.util.Iterator;

/**
 * <big>单向环形带哨兵链表实现队列</big>
 * @author 13684
 * @date 2023/12/6
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
    private final Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity = Integer.MAX_VALUE;

    public LinkedListQueue() {
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    {
        Node<E> node = new Node<>(null, null);
        head = node;
        tail = node;
        node.next = node;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> temp = head.next;
            @Override
            public boolean hasNext() {
                return temp != head;
            }

            @Override
            public E next() {
                E value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    /**
     * <p>向队尾插入值</p>
     * @param value     待插入值
     * @return          插入结果
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        Node<E> node = new Node<>(value, head);
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    /**
     * <p>从队列头获取值，并移除</p>
     * @return      获取的值
     */
    @Override
    public E poll() {
        if (isEmpty()) return null;
        Node<E> node = head.next;
        head.next = head.next.next;
        if (node == tail) tail = head;
        size--;
        return node.value;
    }

    /**
     * <p>从队列头获取值，不移除</p>
     * @return      获取的值
     */
    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * <p>检查队列是否已满</p>
     * @return  是否满
     */
    @Override
    public boolean isFull() {
        return size >= capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private static class Node<E> {
        Node<E> next;
        E value;

        public Node(E value, Node<E> next) {
            this.next = next;
            this.value = value;
        }
    }
}
