package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.HeroNode;

// 单链表
// 无排序实现
public class SignleLinkedList {
    // 头节点，不保存任何数据，只是用作为一个起始点
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点
     * 不考虑编号顺序
     * 1.要找到当前链表的最后一个节点
     * 2.将最后整个节点的next指向新的节点
     */
    public void add(HeroNode node) {
        // 遍历到next为null的时候，进行添加
        // 中间节点(临时节点)
        HeroNode temp = head;
        while (true) {
            // 找到链表的最后，就退出循环
            if (temp.getNext() == null) {
                break;
            }
            // 当前节点有下一个就将地址赋值给临时节点
            temp = temp.getNext();
        }
        // 将最后一个节点的next设置为传入节点
        temp.setNext(node);
    }

    /**
     * 添加节点，考虑顺序
     * 1.先找到该节点要添加的位置
     * 2.改变前一个和该节点的指向
     */
    public Boolean addByOrder(HeroNode node) {
        // head变量不能动，所以我们声明一个临时变量
        HeroNode temp = head;
        // 链表是否为空
        if (isEmpty()) {
            head.setNext(node);
            return true;
        }

        // 判断目标节点是否存在
        if (isExist(node)) {
            System.err.println("编号为" + node.getNo() +"的节点已存在!");
            return false;
        }

        while (true) {
            // 如果为节点尾则打破循环
            if (temp.getNext() == null) break;

            // 如果当前节点的next编号，大于目标节点编号，则找到
            // 应该将目标节点添加到该节点与next之间
            if (temp.getNext().getNo() > node.getNo()) break;

            // 没找到就后移
            temp = temp.getNext();
        }

        // 插入目标节点

        // 将目标节点指向变为该节点的下一个节点
        node.setNext(temp.getNext());
        // 将该节点的下一个节点指向目标节点
        temp.setNext(node);
        return true;
    }

    /**
     * 修改节点
     * 根据no属性来进行查找节点，进行修改，但是不修改next的指向
     */
    public Boolean update(HeroNode updateNode) {
        // 判断链表是否为空
        if (isEmpty()) {
            System.err.println("当前链表为空!");
            return false;
        }

        // 判断节点是否存在
        if (isExist(updateNode)){
            HeroNode temp = head.getNext();
            // 存在则修改
            while (true) {
                // 找到就修改
                if (temp.getNo() == updateNode.getNo()) {
                    temp.setName(updateNode.getName());
                    temp.setNickName(updateNode.getNickName());
                    return true;
                }

                // 找不到就后移
                temp = temp.getNext();
            }
        } else {
            System.err.println("编号为" + updateNode.getNo() + "的节点不存在!");
            return false;
        }
    }

    /**
     * 单链表的删除
     * 根据no属性
     */
    public Boolean delete(int no) {
        if (isEmpty()) {
            System.err.println("链表为空!");
            return false;
        }
        if (isExist(new HeroNode(no, "", ""))) {
            HeroNode temp = head.getNext();
            // 存在则进行删除
            while (true) {
                // 找到要删除的这个节点的前一个节点，
                // 改变前一个节点的指向为下下个节点即可完成删除
                if (temp.getNext().getNo() == no){
                    temp.setNext(temp.getNext().getNext());
                    return true;
                }
                temp = temp.getNext();
            }
        } else {
            System.err.println("要删除的" + no + "号节点不存在!");
            return false;
        }
    }

    /**
     * 展示整个链表
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }

        // 临时节点
        HeroNode temp = head.getNext();
        while (true) {
            System.out.println(temp);
            // 如果到了链表的最后
            if (temp.getNext() == null) break;
            temp = temp.getNext();
        }
    }

    /**
     * 判断链表是否为空
     */
    public Boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * 判断传入节点是否存在
     */
    public Boolean isExist(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            // 链表为空就跳出循环
            if (isEmpty()) return false;

            // 如果编号相等，也说明链表中存在
            if (temp.getNo() == node.getNo()) return true;

            // 当前节点后续没有节点，也说明不存在
            if (temp.getNext() == null) return false;

            // 后移temp
            temp = temp.getNext();
        }
    }
}
