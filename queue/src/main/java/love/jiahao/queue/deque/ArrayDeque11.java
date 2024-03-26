package love.jiahao.queue.deque;

import java.util.Iterator;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/2/26
 */
public class ArrayDeque11<E> implements Deque<E> {
    E[] array;

    int head;
    int tail;
    int size;

    @SuppressWarnings("all")
    public ArrayDeque11(int capacity) {
        array = (E[]) new Object[capacity];
        head = tail = size = 0;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        head = subIndex(head);
        array[head] = e;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        array[tail] = e;
        tail = addIndex(tail);
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        E e = array[head];
        array[head] = null;
        head = addIndex(head);
        size--;
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        tail = subIndex(tail);
        E e = array[tail];
        array[tail] = null;
        size--;
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return array[subIndex(tail)];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int temp = size;
            int first = head;
            @Override
            public boolean hasNext() {
                return temp > 0;
            }

            @Override
            public E next() {
                E e = array[first];
                first = addIndex(first);
                temp--;
                return e;
            }
        };
    }

    private int subIndex(int index) {
        return (index - 1 + array.length) % array.length;
    }

    private int addIndex(int index) {
        return (index + 1) % array.length;
    }
}
