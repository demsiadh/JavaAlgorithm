package love.jiahao.linkedList;

/**
 * <p>力扣82题-删除排序链表中的重复元素</p>
 * @author 13684
 * @date 2023/11/30
 */
public class LC82DeleteDuplicates {
    public static void main(String[] args) {
        ListNode node = ListNode.of(1, 2, 3, 4, 4, 5, 5, 6, 6);
        assert node != null;
        ListNode listNode = deleteDuplicates(node);
        System.out.println(listNode);
    }

    /**
     * <p>递归法</p>
     * <p>如果没有与下一节点相等就返回当前节点继续递归</p>
     * <p>如果与下一节点相等就一直循环到和下一节点不相同，然后继续递归</p>
     * <p>直到递归到最后一个元素</p>
     * @param head  头节点
     * @return      处理后的头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 没有节点或下一个节点时必然没有重复元素
        if (head == null || head.next == null) return head;

        // 当前节点和下一个节点值不同，则head的值需要保留，对head.next继续递归
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            // 当前节点与下一个节点的值重复了，重复的值不能要
            // 一直往下找，找到不重复的节点，返回不重复的节点
            ListNode notDup = head.next.next;
            while (notDup != null && notDup.val == head.val) {
                notDup= notDup.next;
            }
            return deleteDuplicates(notDup);
        }
    }

    /**
     * <p>迭代法</p>
     * <p>添加哨兵节点，直接进行遍历</p>
     * <p>当前节点的下一个节点的值等于下下节点的值的时候，直接跳过下一个节点</p>
     * <p>直到不相等为止</p>
     * @param head  头节点
     * @return      处理后的头节点
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;

        // 哨兵节点
        ListNode prev = new ListNode(0, head);
        // 中间节点
        ListNode temp = prev;
        // 当剩余链表多余2个节点时
        while (temp.next != null && temp.next.next != null) {
            // 如果二者的值相等
            if (temp.next.val == temp.next.next.val) {
                // 保存值
                int x = temp.next.val;
                // 如果下一个节点的值不为空且等于刚才的值
                while (temp.next != null && temp.next.val == x) {
                    // 就跳过下一个节点
                    temp.next = temp.next.next;
                }
            }else temp = temp.next;
        }
        // 返回哨兵节点的下一个节点
        return prev.next;
    }
}
