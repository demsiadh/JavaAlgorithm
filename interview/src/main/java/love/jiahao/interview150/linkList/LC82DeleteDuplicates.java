package love.jiahao.interview150.linkList;

/**
 * <big>删除排序链表中的重复元素</big>
 *
 * @author 13684
 * @date 2024/4/4
 */
public class LC82DeleteDuplicates {
    /*
        采用递归实现
        1. 当当前节点为null或者当前节点下一节点为null时，返回当前节点即可（因为不会有重复）
        2. 如果当前节点的值与下一节点不相同则递归当前节点的下一节点，返回当前节点
        3. 如果当前节点的值与下一节点相同，则需要找到下一个不重复的节点，然后返回该节点
     */
    public ListNode deleteDuplicates(ListNode head) {   // 100 40
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }else {
            ListNode temp = head.next.next;
            while (temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }
    }
}
