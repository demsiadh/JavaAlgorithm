package love.jiahao.hash;

/**
 * <big>哈希表</big>
 *
 * @author 13684
 * @date 2024/3/21
 */
public class MyHashTable {
    Entry[] table = new Entry[16]; // 存放元素的数组
    int size = 0;   // 元素个数
    final float loadFactor = 0.75f; //  负载因子
    int max = (int) (table.length * loadFactor); // 阈值

    /*
    求模运算替换为位运算提升效率
    - 前提： 数组长度为2的n次方
    - 更换为 hash & (数组长度 - 1)
     */


    // 获取元素
    Object get(int hash, Object key) {
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
    void put(int hash, Object key, Object value) {
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
    Object remove(int hash, Object key) {
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
    void resize() {
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
