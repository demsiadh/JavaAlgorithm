package love.jiahao.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * <big>环形数组测试类</big>
 * @author 13684
 * @date 2023/12/8
 */
public class CircleArrayQueueTest {
    private final CircleArrayQueue<Integer> queue = new CircleArrayQueue<>(4);
    @Before
    public void init() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
    }

    @Test
    public void test1() {
        queue.forEach(System.out::println);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.forEach(System.out::println);
    }
}
