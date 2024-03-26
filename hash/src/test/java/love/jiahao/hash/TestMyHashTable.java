package love.jiahao.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/3/21
 */
public class TestMyHashTable {

    @Test
    public void test1() {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put(1, 1, 2);
        myHashTable.put(17, 1, 3);
        myHashTable.put(4, 1, 2);
        myHashTable.put(6, 1, 2);
        myHashTable.put(8, 1, 2);
        System.out.println(myHashTable.size);
        System.out.println(myHashTable.get(1, 1));

        System.out.println(myHashTable.remove(17, 1));
        System.out.println(myHashTable.remove(4, 1));
        System.out.println(myHashTable.size);
    }

    // 测试hash算法
    @Test
    public void test2() {
        MyHashTable2 table2 = new MyHashTable2();
        for (int i = 0; i < 20000; i++) {
            Object o = new Object();
            table2.put(o, o);
        }
        table2.print();

    }
}
