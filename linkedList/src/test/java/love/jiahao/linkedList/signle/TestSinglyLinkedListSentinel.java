package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.signle2.SinglyLinkedList;
import love.jiahao.linkedList.signle2.SinglyLinkedListSentinel;
import org.junit.Before;
import org.junit.Test;

public class TestSinglyLinkedListSentinel {
    private final SinglyLinkedListSentinel singlyLinkedList= new SinglyLinkedListSentinel();

    @Before
    public void init() {
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
    }

    @Test
    public void test() {
        singlyLinkedList.loop3(value -> System.out.println("before:" + value), value -> System.out.println("after:" + value));
    }

    @Test
    public void test2() {
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3() {
        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    public void test4() {
        int i = singlyLinkedList.get(3);
        System.out.println(i);
    }

    @Test
    public void test5() {
        singlyLinkedList.insert(4, 9);
        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    public void test6() {
        singlyLinkedList.removeFirst();
        //System.out.println(i);
        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    public void test7() {
        singlyLinkedList.remove(3);
        singlyLinkedList.forEach(System.out::println);
    }
}
