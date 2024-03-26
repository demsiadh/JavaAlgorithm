package love.jiahao.queue.block;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <big>测试线程安全问题</big>
 * @author 13684
 * @date 2024/2/28
 */
public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock(); // 锁对象
    Condition tailWaits = lock.newCondition(); // 条件变量对象 可以看作一个集合存入线程


    public void offer(String str) {
//        lock.lock();
        try {
            lock.lockInterruptibly();
            while  (isFull()){ // 使用while防止虚假唤醒（线程被唤醒后没有抢到锁，其他线程填满队列后，没有检查继续添加）
                // 满了该做的事。线程阻塞
                tailWaits.await(); // 将当前线程加入tailWaits，并且阻塞
                // 可以由其他线程调用signal()方法唤醒当前线程 这个方法必须配合锁一起使用
            }

            array[tail] = str;
            if (++tail == array.length) tail = 0;
            size++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        TestThreadUnsafe testThreadUnsafe = new TestThreadUnsafe();
        for (int i = 1; i < 11; i++) {
            testThreadUnsafe.offer("e" + i);
        }
        new Thread(() -> {
            System.out.println("准备添加元素");
            testThreadUnsafe.offer("e11");
            System.out.println("添加元素成功");
        }, "t1").start();

        new Thread(() -> {
            try {
                System.out.println("开始唤醒");
                testThreadUnsafe.lock.lockInterruptibly();
                testThreadUnsafe.tailWaits.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                testThreadUnsafe.lock.unlock();
            }
        }, "t2").start();
    }
}
