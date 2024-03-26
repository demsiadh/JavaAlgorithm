package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>冒泡排序</big>
 * <p>比较相邻两个元素的大小，将较大值向后移位，并缩短右边界，直到界限内只剩一个元素</p>
 * <p>优化： 发生移位时就将有边界赋值为移位的位置，而不是每次-1</p>
 * @author 13684
 * @date 2024/3/24
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {2, 4, 3, 8, 5};
        bubble(ints);
        System.out.println(Arrays.toString(ints));
    }

    // 递归实现
    public static void bubble(int[] nums, int right) {
        if (right == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                x = i;
            }
        }
        bubble(nums, x);
    }

    // 非递归实现
    public static void bubble(int[] nums) {
        int right = nums.length - 1;
        while (right > 0) {
            int x = 0;
            for (int i = 0; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    x = i;
                }
            }
            right = x;
        }
    }
}
