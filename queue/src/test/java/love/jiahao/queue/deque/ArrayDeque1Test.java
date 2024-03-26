package love.jiahao.queue.deque;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <big>双向链表实现双端队列</big>
 * @author 13684
 * @date 2024/1/3
 */
public class ArrayDeque1Test {
    private final ArrayDeque1<Integer> linkedListDeque = new ArrayDeque1<>();

    @Before
    public void init() {
        linkedListDeque.offerFirst(1);
        linkedListDeque.offerLast(2);
        linkedListDeque.offerFirst(3);
        linkedListDeque.offerLast(9);
        // 3 1 2 9
    }

    @Test
    public void test1() {

        while (!linkedListDeque.isEmpty()) {
            System.out.println(linkedListDeque.pollFirst());
        }
    }

    @Test
    public void test2() {
        Assert.assertEquals(linkedListDeque.peekLast(), Integer.valueOf(9));
        Assert.assertEquals(linkedListDeque.peekFirst(), Integer.valueOf(3));
        linkedListDeque.offerLast(1);
        linkedListDeque.offerLast(1);
        linkedListDeque.offerLast(1);
        linkedListDeque.offerLast(1);
        Assert.assertFalse(linkedListDeque.offerFirst(1));
        System.out.println(linkedListDeque.size);
        linkedListDeque.forEach(System.out::println);
    }
}
