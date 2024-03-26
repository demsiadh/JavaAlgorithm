package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>选择排序</big>
 * <p>遍历数组，找到最大值，将最大值放到最右边，每次缩短最右边边界</p>
 * <p>优化： 如果较大值索引改变才交换元素</p>
 *
 * @author 13684
 * @date 2024/3/24
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 2, 8};
        choose(ints);
        System.out.println(Arrays.toString(ints));
    }


    // 交换数组元素方法
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
        选择出来最大的放到最右边
        1.选择轮数 length - 1
        2.交换的索引位置 初始是length - 1 每次递减
     */
    private static void choose(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            if (max != i) {
                swap(nums, max, i);
            }
        }
    }
}
