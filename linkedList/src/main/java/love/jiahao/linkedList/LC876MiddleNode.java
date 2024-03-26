package love.jiahao.linkedList;

/**
 * <big>力扣876题-查找链表的中间节点</big>
 * @author 13684
 * @date 2023/11/30
 */
public class LC876MiddleNode {

    public static void main(String[] args) {
        ListNode node = ListNode.of(1, 2, 3);
        ListNode listNode = middleNode(node);
        System.out.println(listNode);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
