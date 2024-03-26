package love.jiahao.linkedList;

/**
 * <big>力扣141题-判断链表是否有环</big>
 * @author 13684
 * @date 2023/12/1
 */
public class LC141HasCycle {
    public static void main(String[] args) {
        ListNode node = ListNode.of(1, 3, 4, 5, 7);
        assert node != null;
        node.next = node;
        System.out.println(hasCycle(node));
    }

    /**
     * <big>快慢指针法</big>
     * <p>快指针每次走两步，慢指针走一步</p>
     * <p>当快指针追上满指针时，证明当前链表有环</p>
     * <p>当快指针走到null时证明链表无环</p>
     * @param head  头节点
     * @return      是否有环
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) return true;
        }

        return false;
    }
}
