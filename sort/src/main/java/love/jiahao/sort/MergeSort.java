package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>归并排序</big>
 * <p>将数组切分，直到切到剩一个元素，认为有序，随后合并，进行合并两个有序数组</p>
 *
 * @author 13684
 * @date 2024/3/26
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 2, 8};
        mergeSort2(ints);
        System.out.println(Arrays.toString(ints));
    }

    // 归并 非递归
    private static void mergeSort2(int[] nums) {
        int length = nums.length;
        int[] a2 = new int[length];

        for (int width = 1; width < length; width = width << 1) {
            for (int left = 0; left < length; left += 2 * width) {
                int rigth = Math.min(left + 2 * width - 1, length - 1);
                int mid = (left + rigth) >> 1;
                merge(nums, left, mid, mid + 1, rigth, a2);
            }
            System.arraycopy(a2, 0, nums, 0, length);
        }
    }

    // 归并排序 递归
    private static void mergeSort(int[] nums) {
        doMergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private static void doMergeSort(int[] nums, int left, int right, int[] a2) {
        // 2. 治
        if (left == right) {
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
