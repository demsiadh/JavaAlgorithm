package love.jiahao.linkedList.signle;

import love.jiahao.linkedList.popj.Boy;

/**
 * 单向环形链表的实现
 */
public class CircleSingleLinkedList {
    Boy first = null;

    /**
     * 添加几个小孩，这里用于初始化，批量添加，构建一个约舍夫丢手帕的n个孩子，与传统的入队列还不一样
     * @param sums      数量
     */
    public void add(int sums) {
        if (sums < 1) throw new RuntimeException("请至少添加一个!");
        Boy cur = null;
        // 遍历
        for (int i = 0; i < sums; i++) {
            Boy boy = new Boy(i);
            // 初始化first节点
            if (first == null) {
                first = boy;
                boy.next = first;
                cur = first;
                continue;
            }
            // 如果不是第一个节点
            cur.next = boy;
            boy.next = first;
            cur = boy;
        }
    }
}
