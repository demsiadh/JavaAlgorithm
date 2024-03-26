package love.jiahao.stack;

import java.util.Iterator;

/**
 * <big>链表实现栈</big>
 * @author 13684
 * @date 2023/12/10
 */
public class LinkedListStack<E> implements Stack<E>,Iterable<E>{
    private final Node<E> head = new Node<>(null, null);
    private int size = 0;
    private int capacity = Integer.MAX_VALUE;   // 栈的容量
    public LinkedListStack() {
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int temp = size;
            private Node<E> tempNode = head.next;
            @Override
            public boolean hasNext() {
                return temp != 0;
            }

            @Override
            public E next() {
                E value = tempNode.value;
                tempNode = tempNode.next;
                temp--;
                return value;
            }
        };
    }

    /**
     * <p>利用头插法实现压栈</p>
     * @param value 元素
     * @return  插入结果
     */
    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Node<E> next = head.next;
        head.next = next.next;
        size--;
        return next.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }


        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }
}
