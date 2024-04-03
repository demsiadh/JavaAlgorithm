package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>快速排序 </big>
 * <p>每次将最右边元素作为基准点，左边放比他小的，右边放比他大的</p>
 * <p>直到left == right则结束递归</p>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class QuickSortLomuto {
    public static void main(String[] args) {
        int[] ints = {1, 2, 8, 5, 4, 3, 6, 7, 9};
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private static void doQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);

        doQuickSort(nums, left, mid - 1);
        doQuickSort(nums, mid + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int mid = nums[right]; // 基准点元素值
        // 两个指针，j寻找比基准点小的，i寻找比基准点大的
        int i = left, j = left;
        while (j < right) {
            if (nums[j] < mid) { // 找到比基准点小的了(隐含条件就是没找到大的)
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
