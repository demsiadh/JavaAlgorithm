package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.HeroNode;

import java.util.Stack;

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

    /**
     * 获取链表的长度
     * @return  链表长度
     */
    public int length() {
        // 没有节点
        if (head.getNext() == null) return 0;
        HeroNode next = head.getNext();
        int count = 0;
        while (next != null) {
            count++;
            next = next.getNext();
        }
        return count;
    }

    /**
     * 查找链表中倒数第k个节点
     * 思路:
     *  1. 获得该链表的总长度
     *  2. 从第一个节点开始循环，一直找到第size-index个节点就是倒数第k个
     * @param index 倒数第几个
     * @return  节点信息
     */
    public HeroNode findLastIndexNode(int index) {
        int size = length();
        // 空链表
        if (size == 0) return null;
        // 校验index
        if (index <= 0 || index > size) return null;

        // 循环查找
        // 因为第一个节点已经被拿出来
        // 所以for循环不必加=了
        HeroNode result = head.getNext();
        for (int i = 0; i < size - index; i++) {
            result = result.getNext();
        }
        return result;
    }

    /**
     * 反转链表
     * 思路：
     *  1. 定义一个新的头节点
     *  2. 从原链表中依次取出节点，并始终添加到新头节点的第一个节点
     *  3. 将原头节点的下一个节点指向新的头节点，保持链表地址不变
     * @return 反转后的链表
     */
    public void reverse() {
        HeroNode cur = head.getNext();
        if (cur == null) return;

        // 1.创建一个反转用的头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode next = null;
        // 2.进行循环
        while (cur != null) {
            // 2.1将当前节点的下一个节点的位置保存起来
            next = cur.getNext();

            // 2.2将当前节点的指向变为反转头节点的下一个
            cur.setNext(reverseHead.getNext());
            // 2.3将反转头节点的下一个节点指向变为当前头节点
            reverseHead.setNext(cur);

            // 2.4将当前节点变为刚才保存的下一个节点，进行下一次循环
            cur = next;
        }
        // 3.循环完毕后，把头节点的指向变为反转后的链表的第一个节点，也就是反转头节点的下一个
        head.setNext(reverseHead.getNext());
    }

    /**
     * 从尾到头打印单链表
     * 思路：
     *  1.利用单链表的反转，然后进行遍历打印,(但是这种做法会破坏原有的链表结构，反转两遍也太不优雅了)
     *  2.利用栈先进后出的特性来进行反转打印
     */
    public void reversePrint() {
        HeroNode cur = head.getNext();
        if (cur == null) return;

        Stack<HeroNode> stack = new Stack<>();
        // 遍历原链表，入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }

        // 打印栈
        while (!stack.empty()) {
            // 出栈并打印
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个单链表
     * 思路：
     *  1.遍历要合并的链表，将值放入数组中，保存起来
     *  2.遍历第二个链表，将对应的节点插入进去
     */
    public void merge(SignleLinkedList list) {
        HeroNode listCur = list.head.getNext();
        HeroNode[] arrList = new HeroNode[list.length()];
        for (int i = 0; i < list.length(); i++) {
            arrList[i] = listCur;
            listCur = listCur.getNext();
        }
        int j = 0;
        HeroNode cur = head.getNext();
        HeroNode next = null;
        while (true) {
            if (cur.getNext() == null) {
                cur.setNext(arrList[j]);
                break;
            }
            next = cur.getNext();
            HeroNode curList = arrList[j];
            if (next.getNo() >= curList.getNo()) {
                cur.setNext(curList);
                curList.setNext(next);
                j++;
            }
            cur = next;
        }
    }
}
