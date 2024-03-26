package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.signle2.CircularDoublyLinkedListSentinel;
import org.junit.Before;
import org.junit.Test;

public class TestCircularDoublyLInkedListSentinel {
    private final CircularDoublyLinkedListSentinel linkedList = new CircularDoublyLinkedListSentinel();

    @Before
    public void init () {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.removeByValue(3);
        linkedList.removeByValue(2);
        linkedList.removeByValue(1);
        linkedList.removeByValue(4);
    }

    @Test
    public void test1() {
        linkedList.forEach(System.out::println);
    }
}
