package love.jiahao.queue.priority;

import love.jiahao.queue.Queue;

/**
 * <big>有序数组实现优先级队列</big>
 * <p>优先级高的排在尾部</p>
 * @author 13684
 * @date 2024/2/27
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;
    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        insert(value);
        return true;
    }

    private void insert(E value) {
        int priority = value.priority();
        int index = size - 1;
        while (index >= 0 && array[index].priority() > priority) {
            array[index + 1] = array[index];
            index--;
        }
        array[index + 1] = value;
        size++;
    }

    @Override
    @SuppressWarnings("all")
    public E poll() {
        if (isEmpty()) return null;
        E result = (E) array[--size];
        array[size] = null;
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[size - 1];
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
