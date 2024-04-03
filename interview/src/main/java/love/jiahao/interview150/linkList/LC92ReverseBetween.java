package love.jiahao.interview150.linkList;

/**
 * <big>反转区间内链表</big>
 *
 * @author 13684
 * @date 2024/3/31
 */
public class LC92ReverseBetween {

    /*
        由于头节点也可能反转，设置一个哨兵节点，next指向头节点
        之后进行遍历，找出需要反转区间的前驱节点和后继节点
        如果后继节点不为null，则遍历区间使最后一个节点指向null，获取头节点，并使前驱节点指向null（截断链表）
        反转截断后的链表
        重新将反转后的链表接入
        最后返回哨兵节点的next
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {    // 100 34
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        int num = 0;
        ListNode temp = sentinel;
        ListNode prev = null;
        ListNode post = null;
        while (temp != null) {
            if (num == left - 1) {
                prev = temp;
            }
            if (num == right + 1) {
                post = temp;
            }
            num++;
            temp = temp.next;
        }

        if (post != null) {
            temp = sentinel;
            num = 0;
            while (temp != null) {
                if (num == right) {
                    temp.next = null;
                    break;
                }
                num++;
                temp = temp.next;
            }
        }
        assert prev != null;
        ListNode node = prev.next;
        prev.next = null;
        ListNode partHead = serverList(node);
        prev.next = partHead;
        temp = partHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = post;

        return sentinel.next;
    }

    private ListNode serverList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode post = head.next;
        ListNode tempHead = head;
        while (post != null) {
            head.next = post.next;
            post.next = tempHead;
            tempHead = post;
            post = head.next;
        }
        return tempHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
