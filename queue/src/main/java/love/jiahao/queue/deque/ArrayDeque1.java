package love.jiahao.queue.deque;

import java.util.Iterator;

/**
 * <big>循环数组实现双端队列1 </big>
 *        h
 *      t
 *  0 1 2 3
 * 尾部添加元素 先添加元素然后tail++
 * 头部添加元素 先head--然后添加元素
 * 头部删除元素 先删除元素，然后head++
 * 尾部删除元素 先tail--然后删除元素
 * @author 13684
 * @date 2024/1/3
 */
public class ArrayDeque1<E> implements Deque<E> {
    E[] array;
    int head;
    int tail;
    int size;

    public ArrayDeque1() {
        this(8);
    }

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (E[]) new Object[capacity];
        head = tail = 0;
        size = 0;
    }

    /**
     * 向队列头部添加元素
     * @param e 元素
     * @return  添加结果
     */
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
        E value = array[head];
        array[head] = null;
        head = addIndex(head);
        size--;
        return value;
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
                E value = array[first];
                first = addIndex(first);
                temp--;
                return value;
            }
        };
    }

    /**
     * 增加索引时的处理方法，防止索引越界
     * @param index     索引
     * @return  处理后的索引
     */
    private int addIndex(int index){
        return (index + 1 + array.length) % array.length;
    }

    /**
     * 减去索引时的处理方法，防止索引越界
     * @param index     索引
     * @return  处理后的索引
     */
    private int subIndex(int index){
        return (index - 1 + array.length) % array.length;
    }
}
