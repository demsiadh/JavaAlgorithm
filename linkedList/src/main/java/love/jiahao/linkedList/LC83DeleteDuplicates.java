package love.jiahao.linkedList;

import java.util.List;

/**
 * <p>力扣83题-删除有序链表中的重复元素</p>
 * @author 13684
 * @date 2023/11/30
 */
public class LC83DeleteDuplicates {
    public static void main(String[] args) {
        ListNode list = ListNode.of(1, 1, 2, 3, 3);
        ListNode listNode = deleteDuplicates2(list);
        System.out.println(listNode);
    }

    /**
     * <p>双指针法</p>
     * <p>使用两个指针一个在前一个在其后面，如果二者相等就跳过当前p2节点</p>
     * <p>随后指针向后移动，直至p2为null为止</p>
     * @param head  头节点
     * @return      去重后的头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
        }
        return head;
    }

    /**
     * <p>递归解法</p>
     * <p>直接进行递归，首先递到最后一个元素，注意 此时应该递归到不为null的节点</p>
     * <p>然后比较当前节点和下一节点的值，如果相等就返回下一节点，抛弃当前节点</p>
     * <p>最终返回的链表就是去重过后的</p>
     * @param head  头节点
     * @return      去重后的头节点
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        head.next = deleteDuplicates2(head.next);
        if (head.val == head.next.val) return head.next;
        else return head;
    }
}
