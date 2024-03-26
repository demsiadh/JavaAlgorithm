package love.jiahao.linkedList;

/**
 * <p>力扣21题-合并有序链表</p>
 *
 * @author 13684
 * @date 2023/11/30
 */
public class LC21MergeTwoLists {
    public static void main(String[] args) {
        ListNode node1 = ListNode.of(1, 2, 5, 7, 9);
        ListNode node2 = ListNode.of(2, 4, 6);
        ListNode listNode = mergeTwoLists2(node1, node2);
        System.out.println(listNode);
    }

    /**
     * <p>哨兵迭代法</p>
     * <p>新建一个哨兵节点</p>
     * <p>将二者的值进行比较。谁比较小就插入哨兵节点链表的下一个</p>
     * <p>随后指针后移，直到其中一个链表为空</p>
     * <p>然后就把不为空的链表连入哨兵链表的最后面</p>
     * <p>最后返回哨兵链表</p>
     *
     * @param node1 链表一
     * @param node2 链表二
     * @return 合并的链表
     */
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // 哨兵节点
        ListNode prev = new ListNode(0), temp = prev;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                temp.next = node2;
                node2 = node2.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
            }
            temp = temp.next;
        }
        temp.next = node1 != null ? node1 : node2;
        return prev.next;
    }

    /**
     * <p>递归法</p>
     * <p>递归终止条件:其中一个链表到头就返回另一个链表就行</p>
     * <p>判断二者的大小，如果比较小就返回较小的那个，剩下的继续递归，不过较小的那个的next</p>
     * <p>需要指向下一轮的较小的结果</p>
     * @param node1     有序链表1
     * @param node2     有序链表2
     * @return          结果链表
     */
    public static ListNode mergeTwoLists2(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        if (node1.val > node2.val) {
            node2.next = mergeTwoLists2(node1, node2.next);
            return node2;
        } else {
            node1.next = mergeTwoLists2(node1.next, node2);
            return node1;
        }
    }
}
