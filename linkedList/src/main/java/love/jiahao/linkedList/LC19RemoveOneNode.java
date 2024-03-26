package love.jiahao.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>力扣19题-删除链表的倒数第n个节点</p>
 * @author 13684
 * @date 2023/11/29
 */
public class LC19RemoveOneNode {
    private static int num;
    public static void main(String[] args) {
        //ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(3,new ListNode(5, null)))));
        ListNode listNode = new ListNode(1, new ListNode(2, null));
        ListNode listNode1 = removeOneNode(listNode, 1);
        ListNode listNode2 = removeOneNode(listNode1, 1);
        System.out.println(listNode2);
    }

    /**
     * <p>递归解决-删除链表倒数第n个节点</p>
     * <ul>
     *     <li>首先递入链表内</li>
     *     <li>出的时候为成员变量计数，由于最后一个是null，并不用担心最后一个占用一个位置，并不会对其计数</li>
     *     <li>计数等于传入的倒数第几个的时候，删除当前的，直接将当前节点掠过返回下一节点即可</li>
     *     <li>没有找到就返回当前节点不做改动</li>
     * </ul>
     * @param head  头节点
     * @param n     第n个节点
     * @return      删除后的头节点
     */
    public static ListNode removeOneNode(ListNode head, int n) {
        if (head == null) {
            // 每次循环到末尾都对成员变量进行初始化，防止上次调用干扰结果
            num = 0;
            return null;
        }
        head.next = removeOneNode(head.next, n);
        num++;
        if (num == n) return head.next;
        else return head;
    }

    /**
     * <p>快慢指针法</p>
     * <p>找寻倒数第几个点，我们就先让快指针走几步，但是由于我们需要删除</p>
     * <p>所以我们先让其走n+1步，找到倒数第n+1个节点，随后删除</p>
     * <ul>
     *     <li>先让快指针走n+1步，然后快慢指针一起走到快指针为null</li>
     *     <li>此时就找到了倒数第n+1个节点，直接进行删除</li>
     * </ul>
     * @param head  头节点
     * @param n     倒数第几个
     * @return      删除后的头节点
     */
    public static ListNode removeOneNode2(ListNode head, int n) {
        // 哨兵节点
        ListNode perv = new ListNode(0, head);
        ListNode p1 = perv;
        ListNode p2 = perv;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return perv.next;
    }
}
