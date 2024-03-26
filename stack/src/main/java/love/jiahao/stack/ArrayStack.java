package love.jiahao.stack;

import java.util.Iterator;

/**
 * <big>数组实现栈</big>
 * @author 13684
 * @date 2023/12/10
 */
public class ArrayStack<E> implements Stack<E>,Iterable<E>{
    private final E[] array;
    private int top = -1; // 栈顶的索引

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int temp = top;
            @Override
            public boolean hasNext() {
                return temp >= 0;
            }

            @Override
            public E next() {
                return array[temp--];
            }
        };
    }

    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        array[++top] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return array[top--];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == array.length - 1;
    }
}
