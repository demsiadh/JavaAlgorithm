package love.jiahao.linkedList;

import love.jiahao.linkedList.popj.PeopleNode;

/**
 * <big>力扣234题-回文链表</big>
 * <p>正着反着都一样的链表叫回文链表</p>
 *
 * @author 13684
 * @date 2023/11/30
 */
public class LC234IsPalindrome {
    public static void main(String[] args) {
        ListNode node1 = ListNode.of(1, 2, 5, 2, 1);
        ListNode node2 = ListNode.of(1, 2);
        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome2(node2));
    }

    /**
     * <big>判断是否是回文链表</big>
     * <p>思路： </p>
     * <p>首先找到中间节点，然后对中间节点进行反转链表</p>
     * <p>循环对比原链表和反转的链表直到反转链表为空，全部一致就是回文链表</p>
     *
     * @param head 头节点
     * @return 是否为回文链表
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode listNode = LC876MiddleNode.middleNode(head);
        ListNode reserve = reserve(listNode);
        ListNode temp1 = head;
        ListNode temp2 = reserve;
        while (temp2 != null) {
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    /**
     * <big>优化后的方法</big>
     * <p>首先在循环快慢指针的同时对前面的链表进行一个反转(每次都将满指针过去的节点头插到新链表)</p>
     * <p>最后进行循环判断，判断新链表和满指针开始的链表是否一致</p>
     * <p>注意如果节点数为奇数会导致满指针指向的节点多一个，这里进行处理，这种情况就从满指针的后一个指针比较</p>
     * @param head 头节点
     * @return 是否为回文链表
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode quick = head;  // 快指针
        ListNode slow = head;   // 满指针
        ListNode n1 = null;     // 新链表的头
        ListNode o1 = head;     // 旧链表的头

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;

            // 反转链表(每次将满指针指向的节点头插到新链表)
            o1.next = n1;   // 旧的节点指向新链表的头节点
            n1 = o1;        // 新链表的节点位置更新
            o1 = slow;      // 旧节点前往下一个节点
        }
        if (quick != null) slow = slow.next;
        while (n1 != null) {
            if (n1.val != slow.val) return false;
            n1 = n1.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reserve(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode perv = head;
        ListNode node = head.next;
        while (node != null) {
            head.next = node.next;
            node.next = perv;
            perv = node;
            node = head.next;
        }
        return perv;
    }
}
