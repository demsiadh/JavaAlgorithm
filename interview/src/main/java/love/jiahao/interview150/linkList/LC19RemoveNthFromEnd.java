package love.jiahao.interview150.linkList;

/**
 * <big>删除链表的倒数第N个结点</big>
 *
 * @author 13684
 * @date 2024/4/3
 */
public class LC19RemoveNthFromEnd {
    private int num;
    /*
        递归调用函数遍历链表，设置当前节点的下一个节点，
        遇到节点为null时给num赋值为0
        递归返回时，每次累加num的值，当num等于n时就说明找到了
        此时不再返回节点，而是返回当前节点的下一个节点
        也就完成了删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {    // 100 66
        if (head == null) {
            num = 0;
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        num++;
        if (num == n) {
            return head.next;
        }else {
            return head;
        }
    }
}
