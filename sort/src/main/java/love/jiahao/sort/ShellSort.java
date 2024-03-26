package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>希尔排序</big>
 * <p>将间隔一致的元素分为一个组，对组内元素进行排序，排完后减小间隔</p>
 * <P>直到间隔等于1排序完成，其实插入排序就是间隔为1的希尔排序</P>
 *
 * @author 13684
 * @date 2024/3/24
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 2, 8};
        shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void shellSort(int[] nums) {
        for (int gap = nums.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < nums.length; low++) {
                int t = nums[low];
                int i = low - gap;

                while (i >= 0 && nums[i] > t) {
                    nums[i + gap] = nums[i];
                    i -=gap;
                }

                if (i != low - gap) {
                    nums[i + gap] = t;
                }
            }
        }
    }
}
