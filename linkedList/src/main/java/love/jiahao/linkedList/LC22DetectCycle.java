package love.jiahao.linkedList;

/**
 * <big>力扣22题-找到环形入口</big>
 * @author 13684
 * @date 2023/12/1
 */
public class LC22DetectCycle {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n3.next = n1;
        ListNode listNode = detectCycle(n1);
        listNode.next = null;
        System.out.println(listNode);
    }

    /**
     * <big>快慢指针法</big>
     * <p>快指针每次走两步，慢指针走一步，直到二者相遇时证明有环</p>
     * <p>由于此时快指针比满指针多走的步数刚好是绕环n圈，此时将满指针重置</p>
     * <p>快慢一起每次走一步，直到下次相遇时就是环形链表的入口</p>
     * @param head  头节点
     * @return      环形链表入口
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                slow = head;
                while (slow != quick) {
                    slow = slow.next;
                    quick = quick.next;
                }
                return quick;
            }
        }
        return null;
    }
}
