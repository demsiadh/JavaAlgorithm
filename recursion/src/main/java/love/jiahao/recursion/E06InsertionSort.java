package love.jiahao.recursion;

import java.util.Arrays;

/**
 * <h1>插入排序</h1>
 * <ul>
 *     <li>左边为排序好的，右边为未排序的，首先保留当前需要排序的值</li>
 *     <li>将保留的值与左边进行比较，如果左边大就右移一位，找到边界，或者左边的值小于插入值</li>
 *     <li>将插入值插入到当前值的后面</li>
 * </ul>
 */
public class E06InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 8, 23, 6, 74, 1};
        insertion(a, 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     *
     * @param arr 数组
     * @param low 未排序的开始索引
     */
    private static void insertion(int[] arr, int low) {
        if (low == arr.length) return;
        // 需要排序的数
        int temp = arr[low];
        int i = low - 1;    // 已排序区域
        // 没有找到插入位置，就把比较大的数向右挪
        // 防止数组越界
        while (i >= 0 && arr[i] > temp) {
            arr[i + 1] = arr[i];
            i--;
        }
        // 找到位置了
        arr[i + 1] = temp;

        insertion(arr, low + 1);
    }

    /**
     * 插入排序另一种实现
     * @param arr   数组
     * @param low   未排序的开始索引
     */
    private static void insertion2(int[] arr, int low){
        if (low == arr.length) return;
        // 排序好的区域
        int i = low - 1;
        while (i >= 0 && arr[i] > arr[i + 1]){
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            i--;
        }
        insertion2(arr, low + 1);
    }
}
