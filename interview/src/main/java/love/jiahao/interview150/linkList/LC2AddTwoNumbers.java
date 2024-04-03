package love.jiahao.interview150.linkList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <big>两数相加</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC2AddTwoNumbers {
    /*
        定义头尾指针，计算每为数字相加起来的数存储（存储时对sum求%10保留个位数）到尾指针
        每次尾指针后移，同时计算进位 sum/10
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // 100 79
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = carry + num1 + num2;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
