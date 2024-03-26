package love.jiahao.queue;

import java.util.Iterator;

/**
 * <big>环形数组实现队列</big>
 * @author 13684
 * @date 2023/12/8
 */
public class CircleArrayQueue<E> implements Queue<E>, Iterable<E>{
    private final E[] array;      // 数组
    private int head = 0;   // 头指针
    private int tail = 0;   // 尾指针

    @SuppressWarnings("all")
    public CircleArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }
    @SuppressWarnings("all")
    public CircleArrayQueue() {
        array = (E[]) new Object[10];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int temp = head;
            @Override
            public boolean hasNext() {
                return temp != tail;
            }

            @Override
            public E next() {
                E e = array[temp];
                temp = (temp + 1) % array.length;
                return e;
            }
        };
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E e = array[head];
        head = (head + 1) % array.length;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return ((tail + 1) % array.length) == head;
    }
}
