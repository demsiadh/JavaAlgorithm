package love.jiahao.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * <big>测试类</big>
 * @author 13684
 * @date 2023/12/6
 */
public class LinkedListQueueTest {
    private static final LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);

    @Before
    public void init() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
    }

    @Test
    public void test1() {
        queue.forEach(System.out::println);
    }

    @Test
    public void test2() {
        System.out.println(queue.peek());
    }

    @Test
    public void test3() {
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
