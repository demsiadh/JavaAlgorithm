package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>堆排序</big>
 * <p>依照选择排序的思想，只不过每次选最大值根据大顶堆的堆顶选取</p>
 *
 * @author 13684
 * @date 2024/3/24
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 2, 8};
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void heapSort(int[] nums) {
        heapify(nums, nums.length); // 建堆
        for (int i = nums.length - 1; i >  0; i--) {
            swap(nums, 0, i);
            down2(nums, 0, i);
        }
    }

    // 建堆
    public static void heapify(int[] nums, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(nums, i, size);
        }
    }

    // 下潜(递归)
    private static void down(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = left + 1;
        int max = index;

        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }

        if (max != index) {
            swap(nums, index, max);
            down(nums, max, size);
        }
    }

    // 下潜(非递归)
    private static void down2(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = left + 1;
        int max = index;

        while (left < size) {
            if (nums[left] > nums[max]) {
                max = left;
            }
            if (right< size && nums[right] > nums[max]) {
                max = right;
            }

            if (max != index) {
                swap(nums, index, max);
                left = max * 2 + 1;
                right = left + 1;
                index = max;
            }else {
                break;
            }

        }
    }


    // 交换
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
