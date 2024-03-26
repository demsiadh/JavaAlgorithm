package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.HeroNode;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestSignleLinkedList {
    private final SignleLinkedList linkedList = new SignleLinkedList();

    @Before
    public void init () {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
    }


    /**
     * 测试单链表
     */
    @Test
    public void testDemo() {
        linkedList.show();
    }

    /**
     * 测试顺序链表
     */
    @Test
    public void testOrderDemo() {
        linkedList.show();
    }

    /**
     * 测试修改链表
     */
    @Test
    public void testUpdate() {

        System.out.println("===修改前===");
        linkedList.show();
        HeroNode updateNode = new HeroNode(4, "张三", "豹子头");
        // 进行修改
        linkedList.update(updateNode);
        System.out.println("===修改后===");
        linkedList.show();
    }

    /**
     * 删除链表
     */
    @Test
    public void testDelete() {
        System.out.println("===删除前===");
        linkedList.show();
        linkedList.delete(3);
        System.out.println("===删除后===");
        linkedList.show();
    }

    /**
     * 链表长度
     */
    @Test
    public void testLength() {
        int length = linkedList.length();
        System.out.println(length);
        linkedList.delete(4);
        System.out.println(linkedList.length());
    }

    /**
     * 查找倒数第k个节点
     */
    @Test
    public void testFind() {
        System.out.println(linkedList.findLastIndexNode(2));
    }
    /**
     * 反转链表
     */
    @Test
    public void reverse() {
        linkedList.reverse();
        linkedList.show();
    }

    /**
     * 反向打印单链表
     */
    @Test
    public void reversePrint() {
        linkedList.show();
        linkedList.reversePrint();
    }

    /**
     * 合并有序链表
     */
    @Test
    public void merge() {
        linkedList.show();
        HeroNode hero1 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(5, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(4, "吴用", "智多星");
        SignleLinkedList list = new SignleLinkedList();
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero3);
        linkedList.merge(list);
        linkedList.show();
    }
    @Test
    public void test() {
        System.out.println(DateTimeFormatter.ofPattern("yyyyMM").format(LocalDate.now()));
    }
}
