package love.jiahao.queue.block;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <big>单锁实现阻塞队列</big>
 * <p>之前的队列没有考虑线程安全问题，并且效率较低</p>
 * <p>让线程进入等待状态而不是返回null或false</p>
 * @author 13684
 * @date 2024/2/28
 */
public class BlockingQueue1<E> implements BlockingQueue<E>{
    private final E[] array;
    private int size;
    private int head;
    private int tail;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition headWaits = lock.newCondition();
    private final Condition tailWaits = lock.newCondition();

    @SuppressWarnings("all")
    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void offer(E e) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) tail = 0;
            size++;
            headWaits.signal(); // 唤醒poll
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                // 如果剩余等待时间没了就返回
                if (nanos < 0) {
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos); // 该方法的返回值为剩余等待的毫秒值
            }
            array[tail] = e;
            if (++tail == array.length) tail = 0;
            size++;
            headWaits.signal(); // 唤醒poll
            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        try{
            lock.lockInterruptibly();
            while(isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head++] = null;
            if (head == array.length) head = 0;
            size--;
            tailWaits.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout) throws InterruptedException {
        try{
            lock.lockInterruptibly();
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while(isEmpty()) {
                if (nanos < 0) {
                    return null;
                }
                nanos = headWaits.awaitNanos(nanos);
            }
            E e = array[head];
            array[head++] = null;
            if (head == array.length) head = 0;
            size--;
            tailWaits.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
