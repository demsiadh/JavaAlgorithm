package love.jiahao.queue.block;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <big>双锁实现阻塞队列</big>
 * <p>单锁情况下不可以同时进行添加和删除，效率比较低</p>
 * @author 13684
 * @date 2024/2/28
 */
public class BlockingQueue2<E>{
    private final E[] array;
    private AtomicInteger size; // 原子类（由于两把锁，但都操作了size所以需要用原子类来保证线程安全）
    private int head;
    private int tail;
    private final ReentrantLock headLock = new ReentrantLock();
    private final ReentrantLock tailLock = new ReentrantLock();
    private final Condition headWaits = headLock.newCondition();
    private final Condition tailWaits = tailLock.newCondition();

    @SuppressWarnings("all")
    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public void offer(E e) throws InterruptedException {
        int c;
        try {
            tailLock.lockInterruptibly();

            // 1.队列为满则等待
            while (isFull()) {
                tailWaits.await();
            }

            // 2.不满则入队
            array[tail] = e;
            if (++tail == array.length) tail = 0;

            // 3.修改size
            c = size.getAndIncrement(); // 返回结果是修改前的结果

            if (c < array.length - 1) {
                tailWaits.signal();
            }

        }finally {
            tailLock.unlock();
        }

        // 4.唤醒等待非空的poll(放在平级是为了解决死锁)
        // 4.1细节：当队列由空变为非空时才唤醒poll，减少锁的抢夺
        // 4.2由poll线程自己唤醒其他poll线程, 反之同理
        if (c == 0) {
            try {
                headLock.lock();
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }



    public E poll() throws InterruptedException {
        E e;
        int c;
        try{
            headLock.lockInterruptibly();
            while(isEmpty()) {
                headWaits.await();
            }
            e = array[head];
            array[head++] = null;
            if (head == array.length) head = 0;

            c = size.getAndDecrement();
            if (c > 1) {
                headWaits.signal();
            }

        }finally {
            headLock.unlock();
        }
        if (c == array.length) {
            try {
                tailLock.lock();
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return e;
    }



    public boolean isEmpty() {
        return size.get() == 0;
    }

    public boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
