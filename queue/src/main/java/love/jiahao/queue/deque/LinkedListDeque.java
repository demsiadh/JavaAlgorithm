package love.jiahao.queue.deque;

import java.util.Iterator;

/**
 * <big>双向环形链表实现双端队列</big>
 *
 * @author 13684
 * @date 2024/1/2
 */
public class LinkedListDeque<E> implements Deque<E>{
    private int capacity;
    private int size;
    private final Node<E> sentinel = new Node<>(null, null, null);

    public LinkedListDeque() {
        this(10);
    }

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> temp = sentinel.next;
            @Override
            public boolean hasNext() {
                return temp != sentinel;
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
     * 往队列头添加节点，由于是双向链表实现
     * 需要知道添加节点的上一个节点和下一个节点
     * a added b
     * @param e 元素
     * @return  添加结果
     */
    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        Node<E> node = new Node<>(sentinel, e, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
        return true;
    }

    /**
     * 往队列尾添加节点，由于是双向链表实现
     * 需要知道添加节点的上一个节点和下一个节点
     * a added b
     * @param e 元素
     * @return  添加结果
     */
    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        Node<E> node = new Node<>(sentinel.prev, e, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
        return true;
    }

    /**
     * 移除队列头部元素
     * @return  移除的元素
     */
    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        Node<E> node = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return node.value;
    }

    /**
     * 移除队列尾部元素
     * @return  移除的元素
     */
    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        Node<E> node = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return node.value;
    }

    /**
     * 查看队列头部元素
     * @return  查看的元素
     */
    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return sentinel.next.value;
    }

    /**
     * 查看队列尾部元素
     * @return  查看的元素
     */
    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
