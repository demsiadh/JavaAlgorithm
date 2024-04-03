package love.jiahao.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <big>快速排序-双边排序</big>
 * <p>每次将最左边元素作为基准点，左边放比他小的，右边放比他大的</p>
 * <p>直到left >= right则结束递归</p>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class QuickSortHandlerDuplicate {
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

    /*
        处理重复元素
     */
    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int nextInt = random.nextInt(left, right + 1);
        // 交换left和随机点
        swap(nums, left, nextInt);

        int mid = nums[left]; // 基准点元素值
        // 两个指针，j寻找比基准点小的，i寻找比基准点大的
        int i = left + 1, j = right;
        while (i <= j) {
            // i 找大的和相等的
            while (i <= j && nums[i] < mid) {
                i++;
            }

            // j 找小的和相等的
            while (i <= j && nums[j] > mid) {
                j--;
            }


            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, j, left);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
