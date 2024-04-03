package love.jiahao.interview150.linkList;

/**
 * <big>合并两个有序链表</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC21MergeTwoLists {

    /*
        递归寻找，每次返回更小的元素，并将更小的元素的next设置为递归调用的结果
        每次递归就传入更小元素链表的下一个元素和另一个链表
     */
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val > node2.val) {
            node2.next = mergeTwoLists(node1, node2.next);
            return node2;
        }else {
            node1.next = mergeTwoLists(node1.next, node2);
            return node1;
        }
    }
}
