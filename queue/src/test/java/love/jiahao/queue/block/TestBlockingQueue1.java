package love.jiahao.queue.block;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * <big>测试单锁实现的阻塞队列</big>
 * @author 13684
 * @date 2024/2/28
 */
public class TestBlockingQueue1 {

    @Test
    public void domain() {
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "begin");
                queue.offer("任务1");
                System.out.println(queue);
                queue.offer("任务2");
                System.out.println(queue);
                queue.offer("任务3");
                System.out.println(queue);
                queue.offer("任务4", 5000);
                System.out.println(queue);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "生产者线程");
        Thread t2 = new Thread(() -> {
            try {
                String poll = queue.poll();
                System.out.println(poll);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "消费者线程");

        t1.start();
        t2.start();


        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
