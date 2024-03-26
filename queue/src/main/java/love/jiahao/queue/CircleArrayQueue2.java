package love.jiahao.queue;

import java.util.Iterator;

/**
 * <big>环形数组实现队列2</big>
 * @author 13684
 * @date 2023/12/8
 */
public class CircleArrayQueue2<E> implements Queue<E>, Iterable<E>{
    private final E[] array;      // 数组
    private int head = 0;   // 头指针
    private int tail = 0;   // 尾指针
    private int size = 0;   // 数组元素个数

    @SuppressWarnings("all")
    public CircleArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }
    @SuppressWarnings("all")
    public CircleArrayQueue2() {
        array = (E[]) new Object[10];
    }

    @Override
    public Iterator<E> iterator() { 
        return new Iterator<>() {
            int temp = head;
            int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public E next() {
                E e = array[temp];
                temp = (temp + 1) % array.length;
                count--;
                return e;
            }
        };
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E e = array[head];
        head = (head + 1) % array.length;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
