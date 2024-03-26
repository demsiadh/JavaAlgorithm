package love.jiahao.recursion;

import java.util.Arrays;

/**
 * <h1>插入排序(对任意区间进行排序)</h1>
 * <ul>
 *     <li>左边为排序好的，右边为未排序的，首先保留当前需要排序的值</li>
 *     <li>将保留的值与左边进行比较，如果左边大就右移一位，找到边界，或者左边的值小于插入值</li>
 *     <li>将插入值插入到当前值的后面</li>
 * </ul>
 */
public class E07InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{2, 50, 8, 23, 6, 74, 1};
        sort(a, 2, 5);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr, int left, int rigth) {
        insertion(arr, left, rigth, left + 1);
    }

    /**
     * 插入排序
     * @param arr 数组
     * @param low 要排序的左边界
     * @param high 排序的右边界
     * @param index 要排序值的索引
     */
    private static void insertion(int[] arr, int low, int high, int index) {
        // 判断索引是否越界
        if (index > high) return;
        // 需要排序的值
        int temp = arr[index];
        int i = index - 1;  // 排序好的区间
        // 不能超过low边界
        while (i >= low && arr[i] > temp) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = temp;
        insertion(arr, low, high, index + 1);
    }
}
