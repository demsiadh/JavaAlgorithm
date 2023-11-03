package love.jiahao.binarySearch;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class TestBinarySearch {
    @Test   // 找到了
    public void test1(){
        int[] a = new int[]{7, 13, 15, 19, 25, 30, 42};
        assertEquals(0, BinarySearchMethods.binarySearchBasic(a, 7));
        assertEquals(1, BinarySearchMethods.binarySearchBasic(a, 13));
        assertEquals(2, BinarySearchMethods.binarySearchBasic(a, 15));
        assertEquals(3, BinarySearchMethods.binarySearchBasic(a, 19));
        assertEquals(4, BinarySearchMethods.binarySearchBasic(a, 25));
        assertEquals(5, BinarySearchMethods.binarySearchBasic(a, 30));
        assertEquals(6, BinarySearchMethods.binarySearchBasic(a, 42));
    }

    @Test   // 没找到
    public void test2(){
        int[] a = new int[]{7, 13, 15, 19, 25, 30, 42};
        assertEquals(-1, BinarySearchMethods.binarySearchBasic(a, 50));
        assertEquals(-1, BinarySearchMethods.binarySearchBasic(a, 18));
        assertEquals(-1, BinarySearchMethods.binarySearchBasic(a, 27));
    }

    @Test
    public void test3(){
        // Java中的二分查找法如果没找到返回值是-i-1，这个数加一再绝对值就是未找到元素的插入位置
        // [2, 5, 8]    a
        // [0, 0, 0, 0] b
        // [2, 4, 0, 0] b
        // [2, 4, 5, 8] b


        int[] a = {2, 5, 8};
        int tartget = 4;
        int i = Arrays.binarySearch(a, tartget);

        System.out.println(i);
        if (i < 0){
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            // 拷贝数组   被复制数组  开始索引  粘贴数组   开始索引      拷贝长度
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = tartget;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }

    }
    @Test
    public void test4(){

    }
}
