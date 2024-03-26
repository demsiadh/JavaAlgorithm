package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.signle2.DoublyLinkedListSentinel;
import org.junit.Before;
import org.junit.Test;

public class TestDoublyLinkedListSentinel {
    private final DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
    @Before
    public void init() {
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);
        doublyLinkedListSentinel.addLast(4);
    }
    @Test
    public void test1() {
        doublyLinkedListSentinel.forEach(System.out::println);
    }

    @Test
    public void test2() {
        doublyLinkedListSentinel.forEach(System.out::println);
        doublyLinkedListSentinel.removeLast();
        doublyLinkedListSentinel.forEach(System.out::println);
    }
}
