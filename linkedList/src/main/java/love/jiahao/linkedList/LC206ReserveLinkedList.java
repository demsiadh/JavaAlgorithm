package love.jiahao.linkedList;

/**
 * <p>力扣206题-反转单链表</p>
 *
 * @author 13684
 * @date 2023/11/29
 */
public class LC206ReserveLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * <p>方法一：直接使用新链表进行头插法反转</p>
         *
         * @param head 头
         * @return 反转后的头节点
         */
        public ListNode reverList1(ListNode head) {
            ListNode node = null;
            for (ListNode temp = head; temp != null; temp = temp.next) {
                node = new ListNode(temp.val, node);
            }
            return node;
        }

        /**
         * <p>方法二：使用移除头节点然后插入头节点</p>
         *
         * @param head 头
         * @return 反转后的头节点
         */
        public ListNode reverList2(ListNode head) {
            LinkedList list1 = new LinkedList(head);
            LinkedList list2 = new LinkedList(null);
            while (true) {
                ListNode node = list1.removeFirst();
                if (node == null) break;
                list2.addFirst(node);
            }

            return list2.head;
        }

        /**
         * 方法三-递归反转
         *
         * @param head 头节点
         * @return 反转后的头节点
         */
        public ListNode reverList3(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode last = reverList3(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        /**
         * <p>方法四-移动头的第二个节点到头去</p>
         * <p>1 -> 2 -> 5 -> 4</p>
         * <ul>
         *     <li>设置指针head旧头，n1新头，o2旧的老二</li>
         *     <li>1(o1,n1) -> 2(o2) -> 5 -> 4</li>
         *     <li>将o2从链表中断开，也就是o1指向o2的下一个节点 head.next = o2.next</li>
         *     <li>o2节点链入链表头部也就是n1 o2.next = n1</li>
         *     <li>切换新头 n1 = o2</li>
         *     <li>o2指向o1的下一个节点 o2 = head.next</li>
         * </ul>
         * @param head  头节点
         * @return      反转后的头节点
         */
        public ListNode reverList4(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode o2 = head.next;
            ListNode n1 = head;
            while (o2 != null) {
                head.next = o2.next;
                o2.next = n1;
                n1 = o2;
                o2 = head.next;
            }
            return n1;
        }

        /**
         * <p>反转链表-直接移动到新链表</p>
         * <ol>
         *     <li>声明一个新的头节点</li>
         *     <li>遍历原来的链表，并保存当前节点的下一个节点</li>
         *     <li>然后将当前节点的next指向刚才创建的头节点</li>
         *     <li>然后将头节点指向当前节点</li>
         *     <li>最后当前节点变为第一步保存的下一个节点</li>
         * </ol>
         * @param head  头节点
         * @return      反转后
         */
        public ListNode reverList5(ListNode head) {
            ListNode n1 = null;
            ListNode temp = head;
            while (temp != null) {
                ListNode o2 = temp.next;
                temp.next = n1;
                n1 = temp;
                temp = o2;
            }
            return n1;
        }
    }

    static class LinkedList {
        ListNode head;

        public LinkedList(ListNode head) {
            this.head = head;
        }

        private void addFirst(ListNode node) {
            node.next = head;
            head = node;
        }

        private ListNode removeFirst() {
            if (head == null) return null;
            ListNode first = head;
            head = head.next;
            return first;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        ListNode node1 = node.reverList3(node);
    }
}
