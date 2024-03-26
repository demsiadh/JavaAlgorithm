package love.jiahao.linkedList;

/**
 * <p>力扣203题-移除链表元素(根据值)</p>
 *
 * @author 13684
 * @date 2023/11/29
 */
public class LC203RemoveElements {

    /**
     * <p>删除指定值的所有节点变更返回新的头节点（创建新的头节点法指向链表）</p>
     * @param head  头节点
     * @param val   要删除的值
     * @return      新的头节点
     */
    public static ListNode removeElements1(ListNode head, int val){
        if (head == null) return null;
        // 新建一个节点连接链表
        ListNode node = new ListNode(0, head);
        ListNode temp = node;
        while (temp.next != null) {
            if (temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return node.next;
    }

    /**
     * <p>删除链表中对应值的节点-递归</p>
     * @param head  头节点
     * @param val   目标值
     * @return      删除后的头节点
     */
    public static ListNode removeElements2(ListNode head, int val) {
        // 当前节点为null时就直接返回null
        if (head == null) return null;
        // 对下一个节点进行递归判断
        head.next = removeElements2(head.next, val);
        // 递完时，判断是否等于val
        // 如果等于就返回当前节点的下一个（也就是跳过当前节点）
        // 不相等就返回当前节点
        if (head.val == val) {
            return head.next;
        }else return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7, null)));
        ListNode node = removeElements1(listNode, 7);
        System.out.println(node);
    }
}
