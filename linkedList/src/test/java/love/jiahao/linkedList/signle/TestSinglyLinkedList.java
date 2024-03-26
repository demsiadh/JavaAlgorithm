package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.signle2.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import java.util.function.Consumer;

public class TestSinglyLinkedList {
    private final SinglyLinkedList singlyLinkedList= new SinglyLinkedList();

    @Before
    public void init() {
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
    }

    @Test
    public void test() {
        singlyLinkedList.loop2(System.out::println);
    }

    @Test
    public void test2() {
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3() {
        singlyLinkedList.addLast(6);
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
        int i = singlyLinkedList.removeFirst();
        //System.out.println(i);
        singlyLinkedList.forEach(System.out::println);
    }

    @Test
    public void test7() {
        singlyLinkedList.remove(3);
        singlyLinkedList.forEach(System.out::println);
    }
}
