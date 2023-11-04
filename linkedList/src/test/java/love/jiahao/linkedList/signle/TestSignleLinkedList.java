package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.HeroNode;
import org.junit.Test;

public class TestSignleLinkedList {


    /**
     * 测试单链表
     */
    @Test
    public void testDemo() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");

        SignleLinkedList linkedList = new SignleLinkedList();
        // 可以看到这里的链表并没有顺序，按插入顺序排放的
        linkedList.add(hero1);
        linkedList.add(hero4);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.show();
    }

    /**
     * 测试顺序链表
     */
    @Test
    public void testOrderDemo() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");

        SignleLinkedList linkedList = new SignleLinkedList();
        // 可以看到这里的链表并没有顺序，按插入顺序排放的
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero3);
        linkedList.show();
    }

    /**
     * 测试修改链表
     */
    @Test
    public void testUpdate() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        SignleLinkedList linkedList = new SignleLinkedList();
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);

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
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        SignleLinkedList linkedList = new SignleLinkedList();
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);

        System.out.println("===删除前===");
        linkedList.show();
        linkedList.delete(3);
        System.out.println("===删除后===");
        linkedList.show();
    }
}
