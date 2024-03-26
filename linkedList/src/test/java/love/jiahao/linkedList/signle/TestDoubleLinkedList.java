package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.HeroNode;
import love.jiahao.linkedList.popj.PeopleNode;
import org.junit.Before;
import org.junit.Test;

public class TestDoubleLinkedList {
    private final DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    @Before
    public void init () {
        PeopleNode peopleNode1 = new PeopleNode(0, "张三", "张");
        PeopleNode peopleNode2 = new PeopleNode(1, "李四", "李");
        PeopleNode peopleNode3 = new PeopleNode(2, "麻子", "麻");
        doubleLinkedList.addLast(peopleNode1);
        doubleLinkedList.addLast(peopleNode2);
        doubleLinkedList.addLast(peopleNode3);
    }

    @Test
    public void test1() {
        // 打印全部
        doubleLinkedList.printAll();
        // 更改节点
        System.out.println("----------------------");
        boolean b = doubleLinkedList.updateNode(new PeopleNode(0, "王二", "王"));
        System.out.println(b);
        doubleLinkedList.printAll();
        // 删除节点
        System.out.println("------------------------");
        PeopleNode delete = doubleLinkedList.delete(2);
        System.out.println(delete);
    }

    @Test
    public void test2() {
        doubleLinkedList.addOrderByNo(new PeopleNode(5, "", ""));
        doubleLinkedList.printAll();
        doubleLinkedList.addOrderByNo(new PeopleNode(4, "", ""));
        doubleLinkedList.printAll();
    }
}
