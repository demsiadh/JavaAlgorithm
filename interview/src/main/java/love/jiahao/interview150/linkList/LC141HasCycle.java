package love.jiahao.interview150.linkList;

/**
 * <big>环形链表</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC141HasCycle {

    /*
        利用快慢指针，快指针一次走两步，满指针走一步，如果链表中有环
        则一定会再次相遇，直到quick指针没有下一个元素，证明没有环
     */
    public boolean hasCycle(ListNode head) {    // 100 36
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }

        return false;
    }
}
