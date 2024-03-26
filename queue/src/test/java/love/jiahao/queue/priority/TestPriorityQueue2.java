package love.jiahao.queue.priority;



import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <big>测试有序 数组实现优先级队列</big>
 *
 * @author 13684
 * @date 2024/2/27
 */
public class TestPriorityQueue2 {

    @Test
    public void domain() {
        PriorityQueue2<Entry<String>> queue = new PriorityQueue2<>(3);
        queue.offer(new Entry<>("task1", 3));
        queue.offer(new Entry<>("task2", 2));
        queue.offer(new Entry<>("task3", 1));

        assertFalse(queue.offer(new Entry<>("task4", 4)));

        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
        assertNull(queue.poll());
    }
}
