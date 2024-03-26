package love.jiahao.recursion;

import java.util.Arrays;

/**
 * <p>递归冒泡排序</p>
 * <p>将数组划分为两个部分</p>
 * <p>左边为未排序部分，右边为排序部分</p>
 * <p>在未排序部分区间，相邻的两个元素比较，如果前一个大于后一个就交换位置</p>
 */
public class E05BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 2, 8, 45, 33, 24, 57};
        bubble(arr, arr .length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr       数组
     * @param right     右边界
     */
    private static void bubble(int[] arr, int right) {
        // 右边界等于0就结束递归
        if (right == 0) return;
        // 每次循环时声明一个x
        int x = 0;
        for (int i = 0; i < right; i++) {
            // 如果左边数比右边数大就交换位置
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                // 如果发生交换就吧i的值赋值给x，这时x右边的值就是有序的，可以直接将该x作为右边界传递给下一次递归
                x = i;
            }
        }
        // 缩小范围
        bubble(arr, x);
    }
}
