package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>归并插入排序，因为归并适合数据量大的排序，而插入适合数据量小的</big>
 *
 * @author 13684
 * @date 2024/3/26
 */
public class MergeInsertSort {
    public static void main(String[] args) {
        int[] ints = {1, 6, 4, 3, 2, 9, 10};
        int[] ints2 = {5, 2, 3, 1};
        mergeSort(ints2);
        System.out.println(Arrays.toString(ints2));
    }

    // 归并排序 递归
    private static void mergeSort(int[] nums) {
        doMergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    // 插入排序 非递归
    private static void insertSort(int[] nums, int left, int right) {
        int t;  // 每次需要排序的元素
        int i;  // 已排序区域的右边界
        for (int low = left; low <= right; low++) {
            t = nums[low];
            i = low - 1;
            while (i >= left && t < nums[i]) {
                nums[i + 1] = nums[i];
                i--;
            }

            if (i != low - 1) {
                nums[i + 1] = t;
            }
        }
    }

    private static void doMergeSort(int[] nums, int left, int right, int[] a2) {
        // 2. 治
        if (left - right <= 32) {
            insertSort(nums, left, right);
            return;
        }

        // 1. 分
        int mid = (left + right) >>> 1;
        doMergeSort(nums, left, mid, a2);
        doMergeSort(nums, mid + 1, right, a2);

        // 3. 合
        merge(nums, left, mid, mid + 1, right, a2);
        System.arraycopy(a2, left, nums, left, right - left + 1);
    }

    // 合并两个有序数组
    private static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }
}
