package love.jiahao.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <big>桶排序 - 改进</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class BucketSortGeneric {
    public static void main(String[] args) {
        int[] ints = {9, 0, 5, 1, 3, 2, 4, 6, 8, 7};
        bucketSort(ints, 3);
        System.out.println(Arrays.toString(ints));
    }

    /*
        1. 准备桶
        2. 将对应的数据放入同一个桶
        3. 桶内元素排序
        4. 排好序依次填入数组
     */
    // 第二个参数代表每个桶最多有几个元素
    private static void bucketSort(int[] nums, int range) {
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
        // 1. 准备桶
        int temp = (max - min) / range + 1;
        List<List<Integer>> buckets = new ArrayList<>(temp);
        for (int i = 0; i < temp; i++) {
            buckets.add(new ArrayList<>());
        }
        // 2. 放入数据
        for (int num : nums) {
            buckets.get(temp - 1).add(num);
        }

        int k = 0;
        for (List<Integer> bucket : buckets) {
            // 3.桶内排序
            bucket.sort(null);
            System.out.println(bucket);
            // 4. 桶内数据填入数组
            for (int num : bucket) {
                nums[k++] = num;
            }
        }
    }
}
