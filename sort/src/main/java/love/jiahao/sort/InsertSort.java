package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>插入排序</big>
 * <p>将左边视为已排序的区域，每次将右边的元素插入一个进去</p>
 * <p>插入到i小于0或者插入元素大于当前元素的后一个位置</p>
 *
 * @author 13684
 * @date 2024/3/24
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 2, 8};
        insertSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    // 插入排序 非递归
    private static void insertSort(int[] nums) {
        int t;  // 每次需要排序的元素
        int i;  // 已排序区域的右边界
        for (int low = 1; low < nums.length; low++) {
            t = nums[low];
            i = low - 1;
            while (i >= 0 && t < nums[i]) {
                nums[i + 1] = nums[i];
                i--;
            }

            if (i != low - 1) {
                nums[i + 1] = t;
            }
        }
    }

    // 插入排序 递归
    private static void insertion(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }
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
}
