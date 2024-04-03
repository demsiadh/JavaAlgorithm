package love.jiahao.sort;

import java.util.Arrays;

/**
 * <big>计数排序-改进可排序负数</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class CountingSortPositive {
    public static void main(String[] args) {
        int[] ints = {2, 8, 4, 1, 5, 6, -1};
        countingSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    /*
         改进版 可排序负数
         1. 找到最大值和最小值，创建一个max - min + 1长度的数组
         2. 将最小值元素作为0号count元素，所以就需要进行偏移，所以此时偏移量就是-min
         3. 往count数组中填入计数，位置都需要偏移量
         4. 填回数据时需要把元素也减去偏移量 - offset(也就是加上最小值)
     */
    private static void countingSort(int[] nums) {  // 100 38
        // 1. 找最大值
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int offset = -min;
        int[] count = new int[max - min + 1];
        // 2. 计数
        for (int num : nums) {
            count[num + offset]++;
        }

        int j = 0;
        // 3.重新填入
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[j++] = i - offset;
                count[i]--;
            }
        }
    }
}
