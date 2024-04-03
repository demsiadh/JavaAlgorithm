package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>计数排序</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] ints = {2, 8, 4, 1, 5, 6};
        countingSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    /*
        1. 找到最大值，创建一个最大值加一的count数组
        2. 遍历原始数组，在count数组中记录每个元素的出现次数
        3，遍历count数组将计数减为零，对应的索引作为值覆盖原来的数组
        弊端：只能用于数据量较小，只有正整数
     */
    private static void countingSort(int[] nums) {
        // 1. 找最大值
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int j = 0;
        int[] count = new int[max + 1];
        // 2. 计数
        for (int num : nums) {
            count[num]++;
        }

        // 3.重新填入
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[j++] = i;
                count[i]--;
            }
        }
    }
}
