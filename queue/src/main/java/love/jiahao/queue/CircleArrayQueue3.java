package love.jiahao.queue;

import java.util.Iterator;

/**
 * <big>环形数组实现队列3</big>
 * <p>head和tail只作为一个自增的数而不是索引，需要用到时在计算</p>
 * @author 13684
 * @date 2023/12/8
 */
public class CircleArrayQueue3<E> implements Queue<E>, Iterable<E>{
    private final E[] array;      // 数组
    private int head = 0;   // 头指针
    private int tail = 0;   // 尾指针

    @SuppressWarnings("all")
    public CircleArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }
    @SuppressWarnings("all")
    public CircleArrayQueue3() {
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
                E e = array[temp % array.length];
                temp++;
                return e;
            }
        };
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail % array.length] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E e = array[head % array.length];
        head++;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }
}
