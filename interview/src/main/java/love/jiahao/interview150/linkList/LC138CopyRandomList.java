package love.jiahao.interview150.linkList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <big>链表的深拷贝</big>
 *
 * @author 13684
 * @date 2024/3/31
 */
public class LC138CopyRandomList {
    /*
        创建map存储每一个对应原来链表节点创建出来的副本
        递归链表，如果map中没有当前节点的副本就为当前节点创建并添加到map中
        并且让当前副本指向他们
        如果有了副本并且当前节点不是null就返回map中对应的副本
     */
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {     // 100 21
        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node headNew = new Node(head.val);
            map.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }
}
