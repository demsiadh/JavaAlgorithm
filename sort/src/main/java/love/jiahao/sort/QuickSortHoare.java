package love.jiahao.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <big>快速排序-双边排序</big>
 * <p>每次将最左边元素作为基准点，左边放比他小的，右边放比他大的</p>
 * <p>直到left == right则结束递归</p>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class QuickSortHoare {
    public static void main(String[] args) {
        int[] ints = {21, 88, 19, 45, 13, 25, 66, 33, 18};
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
        注意点以及细节点
        1. 内层循环增加i < j 条件，  防止循环过程中越界
        2. 先处理j后处理i 先处理i会导致最终与i交换位置出现错误
        3. 随机元素作为基准点 防止极端情况出现（比如降序数组）
     */
    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int nextInt = random.nextInt(left, right + 1);
        // 交换left和随机点
        swap(nums, left, nextInt);

        int mid = nums[left]; // 基准点元素值
        // 两个指针，j寻找比基准点小的，i寻找比基准点大的
        int i = left, j = right;
        while (i < j) {
            // j 找小的
            while (i < j && nums[j] > mid) {
                j--;
            }

            // i 找大的
            while (i < j && nums[i] <= mid) {
                i++;
            }

            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
