package love.jiahao.sort.lc;

import java.util.Arrays;

/**
 * <big>按照频率将数组升序排序</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC1636FrequencySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
    }
    /*
        由于题目是要求按照频率进行排序，所以采用计数排序
        1。首先找出最大值和最小值，初始化计数器
        2. 随后遍历在计数器中挑选最小的频率（需要大于0，并且相同元素降序排序，所以查找最小值可以小于等于）按照顺序添加到数组中
        3. 返回结果数组
     */
    public static int[] frequencySort(int[] nums) { // 100 94
        // 1.初始化计数器
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        // 2.遍历数组，将计数器元素填入数组
        int k = 0;
        while (k < nums.length) {
            int index = findMin(count);
            while (count[index] > 0) {
                nums[k++] = index + min;
                count[index]--;
            }
        }
        return nums;
    }

    // 寻找数组中的最小值（大于0），返回最小值索引，有相同最小值返回后面的索引
    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number <= min && number > 0) {
                min = number;
                index = i;
            }
        }
        return index;
    }
}
