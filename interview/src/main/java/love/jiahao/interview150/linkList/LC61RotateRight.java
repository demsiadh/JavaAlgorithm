package love.jiahao.interview150.linkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>右旋链表</big>
 *
 * @author 13684
 * @date 2024/4/5
 */
public class LC61RotateRight {
    public static void main(String[] args) {
        ListNode node = new LC61RotateRight().rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    /*
        双指针解法
        1. 首先定义头尾指针，找到链表的头和尾
        2. 将头尾相连，形成环状
        3. 让头指针和尾指针分别往后移动 链表节点个数 - k % 链表节点个数 个节点
        4. 将尾指针的next断开，返回头指针
     */
    public ListNode rotateRight(ListNode head, int k) { // 100 33
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode last = head;
        int num = 0;
        while (last.next != null) {
            num++;
            last = last.next;
        }
        num++;
        last.next = first;
        int count = num - k % num;
        for (int i = 0; i < count; i++) {
            first = first.next;
            last = last.next;
        }
        last.next = null;
        return first;
    }

    /*
        暴力解法：
        1. 创建一个集合存入所有的节点
        2. 将集合中后面的节点往集合头添加 k % 节点个数次
        3. 将集合的节点连起来
        4. 返回集合第一个元素
     */
    public ListNode rotateRight2(ListNode head, int k) {     // 10 5
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.size() == 0) {
            return null;
        }

        for (int i = 0; i < k % list.size(); i++) {
            list.add(0, list.remove(list.size() - 1));
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).next = null;
            } else {
                list.get(i).next = list.get(i + 1);
            }
        }

        return list.get(0);
    }
}
