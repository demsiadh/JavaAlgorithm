package love.jiahao.linkedList;

/**
 * <p>力扣23题-合并多个升序链表</p>
 * @author 13684
 * @date 2023/11/30
 */
public class LC23MergeKLists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                ListNode.of(1, 3, 5),
                ListNode.of(2, 2, 6),
                ListNode.of(4, 5, 6)
        };
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }

    /**
     * <p>合并多个链表</p>
     * @param lists     链表数组
     * @return          返回结果链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return split(lists, 0, lists.length - 1);
    }

    /**
     * <p>切分链表并合并</p>
     * <p>将链表根据边界切分为不能再切，然后合并左右链表</p>
     * <p>最后逐层合并，得到结果链表</p>
     * @param lists     数组链表
     * @param i         左边界
     * @param j         右边界
     * @return          合并后的链表
     */
    public static ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return LC21MergeTwoLists.mergeTwoLists(left, right);
    }

}
