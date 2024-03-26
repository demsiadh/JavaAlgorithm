package love.jiahao.hash;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * <big>哈希表-实现hash算法</big>
 *
 * @author 13684
 * @date 2024/3/21
 */
/*
1. 我们的代码里使用了尾插法，如果改成头插法呢？
头插法也一样，但是在jdk7中hashmap采用头插法，在多线程的情况下出现了死循环，jdk8之后就采用了尾插法所以比较推荐尾插法

2. JDK 的 HashMap 中采用了将对象 hashCode 高低位相互异或的方式减少冲突，怎么理解
因为计算索引由于是取余运算，通常跟高位没什么关系，如果地位相同则hash运算后取得索引也一样，冲突较多，而jdk中则采用高位与地位进行异或运算，从而减少了hash冲突

3. 我们的 HashTable 中表格容量是 2 的 n 次方，很多优化都是基于这个前提，能否不用 2 的 n 次方作为表格容量？
可以不用2的n次方作为容量，采用质数容量存储，可以使数据分布的更均匀，但是这样就需要进行取余和除法等运算，效率不如位运算，看使用场景了

4. JDK 的 HashMap 在链表长度过长会转换成红黑树，对此你怎么看
这是为了防止存放恶意数据，一般来说我们的数据不会出现同一个位置超过8或者以上的情况，而如果被人恶意攻击，则链表的长度一直增加，会大大增加服务器的压力，而jdk
就采用了转换为红黑树来解决这一问题

 */



public class MyHashTable2 {
    Entry[] table = new Entry[16]; // 存放元素的数组
    int size = 0;   // 元素个数
    final float loadFactor = 0.75f; //  负载因子
    int max = (int) (table.length * loadFactor); // 阈值

    /*
    求模运算替换为位运算提升效率
    - 前提： 数组长度为2的n次方
    - 更换为 hash & (数组长度 - 1)
     */

    public Object get(Object key) {
        return get(getHash(key), key);
    }

    public void put(Object key, Object value) {
        put(getHash(key), key, value);
    }

    public Object remove(Object key) {
        return remove(getHash(key), key);
    }

    // 获取元素
    private Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        Entry temp = table[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }

            temp = temp.next;
        }
        return null;
    }

    // 添加或修改元素
    private void put(int hash, Object key, Object value) {
        // 1.判断是否有空位
        int index = hash & (table.length - 1);
        Entry entry = table[index];
        if (entry == null) {
            table[index] = new Entry(hash, key, value);
            size++;
            if (size > max) {
                resize();
            }
            return;
        }

        // 2.没有空位
        while (true) {
            // 2.1如果有重复
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            // 2.2没有重复
            if (entry.next == null) {
                break;
            }
            entry = entry.next;
        }
        // 3.新增到链表尾部
        entry.next = new Entry(hash, key, value);
        size++;
        if (size > max) {
            resize();
        }
    }

    // 删除元素
    private Object remove(int hash, Object key) {
        int index = hash & (table.length - 1);
        // 1. 如果在数组中不存在则直接返回
        if (table[index] == null) {
            return null;
        }

        // 2.遍历链表
        Entry temp = table[index];
        Entry prev = null;
        while (temp != null) {
            if (temp.key.equals(key)) {
                // 如果为链表头则修改该数组
                 if (prev == null) {
                     table[index] = temp.next;
                     // 不为链表头则修改链表
                 }else {
                     prev.next = temp.next;
                 }
                 // size--
                 size--;
                 return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }

        return null;
    }

    // 扩容
    private void resize() {
        // 1. 新数组长度为原来的两倍(可以保持2的n次方)
        Entry[] newTable = new Entry[table.length << 1];
        // 2. 遍历原来的数组将元素移动到新数组中去
        for (int i = 0; i < table.length; i++) {
            // 2.1 拿到每个链表头
            Entry temp = table[i];
            if (temp != null) {
                Entry a = null; // 第一组 最后一个节点
                Entry b = null; // 第二组 最后一个节点
                Entry aHead = null; // 第一组头节点
                Entry bHead = null; // 第二组头节点
                // 2.2循环拷贝
                while (temp != null) {
                    if ((temp.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = temp;
                        } else {
                            aHead = temp;
                        }
                        a = temp;
                    }else {
                        if (b != null) {
                            b.next = temp;
                        } else {
                            bHead = temp;
                        }
                        b = temp;
                    }
                    temp = temp.next;
                }
                // 2.3循环结束 移动头节点
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null){
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        // 3. 移动完成后重新设置属性
        this.table = newTable;
        this.max = (int) (newTable.length * this.loadFactor);
    }

    private int getHash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    // 输出每个位置都有多少个元素（为了测试hash算法的好坏）
    public void print() {
        int length = table.length;
        int sum = 0;
        Entry temp;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            temp = table[i];
            while (temp != null) {
                sum++;
                temp = temp.next;
            }

            result[i] = sum;
            sum = 0;
        }
//        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())));
    }




    private static class Entry {
        int hash; // 哈希
        Object key;
        Object value;
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
