package love.jiahao.array;

import org.junit.Test;

import java.util.List;


import static junit.framework.TestCase.assertEquals;


public class TestDynamicArray {
    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        // dynamicArray.addLast(5);
        dynamicArray.add(2, 5);

        dynamicArray.foreach(System.out::println);
    }

    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        for (Integer integer : dynamicArray) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.stream().forEach(System.out::println);
    }
    @Test
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        int remove = dynamicArray.remove(1);
        assertEquals(2, remove);

        System.out.println(remove);
        for (Integer integer : dynamicArray) {
            System.out.println(integer);
        }
    }

    @Test
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        
        dynamicArray.foreach(System.out::println);
    }
}
