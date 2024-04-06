package love.jiahao.interview150.linkList;

import java.util.ArrayList;
import java.util.List;

/**
 * <big>分隔链表</big>
 *
 * @author 13684
 * @date 2024/4/6
 */
public class LC86Partition {
    /*
        采用额外的空间
        1. 定义两个链表，分别存放较小的值和较大的值
        2. 遍历判断节点的值，分别放入对应的链表当中
        3. 将最后的节点指向置为null，偏小的最后节点指向偏大节点的第一个
        4. 返回偏小节点的头部节点
     */
    public ListNode partition(ListNode head, int x) {   // 100 68
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode larger = new ListNode(0);
        ListNode largerHead = larger;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        larger.next = null;
        small.next = largerHead.next;
        return smallHead.next;
    }
}
