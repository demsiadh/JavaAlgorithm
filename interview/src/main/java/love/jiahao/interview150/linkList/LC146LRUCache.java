package love.jiahao.interview150.linkList;

import java.util.*;

/**
 * <big>LRU缓存-最近最少使用</big>
 *
 * @author 13684
 * @date 2024/4/7
 */
public class LC146LRUCache {    // 93 76
    /*
        hashMap+双向链表
        1. 使用hashmap作为存储数据的容器
        2. 每次添加数据将数据添加到hashmap中和双向链表的头部
        3. 当容量满了时，将双向链表的尾部数据删除，同时将hashmap中对应的数据删除
        4. 获取数据时，将数据移动到双向链表的头部
     */
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    public LC146LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode linkedNode = new DLinkedNode(key, value);
            cache.put(key, linkedNode);
            addToHead(linkedNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                assert tail != null;
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        if (tail.prev != head) {
            DLinkedNode prev = tail.prev;
            removeNode(prev);
            return prev;
        }
        return null;
    }

    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
