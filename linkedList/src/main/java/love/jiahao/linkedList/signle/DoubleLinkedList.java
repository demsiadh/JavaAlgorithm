package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.PeopleNode;

/**
 * 双链表
 */
public class DoubleLinkedList {
    // 头节点
    private final PeopleNode head = new PeopleNode(0, "", "");

    /**
     * 添加：将节点添加到链表尾部
     *
     * @param node 节点
     */
    public void addLast(PeopleNode node) {
        if (node == null) return;
        // 找到链表的末尾
        PeopleNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        // 将新节点添加到末尾上
        temp.setNext(node);
        node.setPre(temp);
    }

    /**
     * 按顺序添加节点
     *
     * @param node 节点
     */
    public void  addOrderByNo(PeopleNode node) {
        // 1.健壮性判断
        this.isEmpty();
        if (node == null) return;

        // 2.循环遍历所有节点
        PeopleNode temp = head.getNext();
        while (true) {
            // 2.1找到末尾
            if (temp.getNext() == null) {
                // 将该节点添加到末尾
                temp.setNext(node);
                node.setPre(temp);
                return;
            }
            // 2.2找到位置
            if (temp.getNext().getNo() > node.getNo()) {
                // 将当前节点插入进去
                PeopleNode next = temp.getNext();
                temp.setNext(node);
                node.setNext(next);
                next.setPre(node);
                return;
            }
            // 2.3相同
            if (temp.getNo() == node.getNo()) {
                throw new RuntimeException("已有当前节点!");
            }
            // 2.4进行下一次循环
            temp = temp.getNext();
        }
    }

    /**
     * 更新: 以id匹配，更新链表中找到的节点;与单向链表的逻辑基本一致
     *
     * @param peopleNode 需要更新的节点
     * @return 更新结果
     */
    public boolean updateNode(PeopleNode peopleNode) {
        // 1.健壮性校验
        if (peopleNode == null) throw new RuntimeException("参数不合法!");
        this.isEmpty();
        // 2.进行寻找
        // 2.1得到第一个节点
        PeopleNode temp = head.getNext();
        // 2.3循环遍历
        while (temp.getNo() != peopleNode.getNo()) {
            // 如果找到了
            // 如果到了最后一个还没找到就是没找到
            if (temp.getNext() == null) return false;
            // 进行下一次循环
            temp = temp.getNext();
        }

        // 3.存在就替换属性
        temp.setName(peopleNode.getName());
        temp.setNickName(peopleNode.getNickName());
        return true;
    }

    /**
     * 根据编号删除节点
     * @param no    编号
     * @return      删除的节点
     */
    public PeopleNode delete(int no) {
        // 1.健壮性校验
        this.isEmpty();
        PeopleNode temp = head.getNext();
        // 2.遍历查找
        while (true) {

            // 2.1如果找到，就将其前后节点的后置节点和前置节点位置改变就可以了
            if (temp.getNo() == no) {
                // 2.2上一个节点的下一个节点指向当前节点的下个节点
                temp.getPre().setNext(temp.getNext());
                // 2.3如果有下一个节点，下一个节点指向当前上一个节点
                if (temp.getNext() != null) temp.getNext().setPre(temp.getPre());
                // 2.4返回当前节点
                return temp;
            }

            // 2.5没找到就返回null
            if (temp.getNext() == null) return null;
            // 2.6进行下一轮循环
            temp = temp.getNext();
        }
    }

    /**
     * 打印当前所有节点
     */
    public void printAll() {
        this.isEmpty();
        PeopleNode temp = head.getNext();
        // 循环打印
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 判断链表是否为空
     */
    public void isEmpty() {
        if (head.getNext() == null) {
            throw new RuntimeException("当前链表为空!");
        }
    }
}
