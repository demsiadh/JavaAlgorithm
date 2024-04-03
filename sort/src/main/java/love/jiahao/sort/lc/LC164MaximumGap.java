package love.jiahao.sort.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <big>最大间距</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC164MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap2(new int[]{1, 1_000_000}));
    }
    public static int maximumGap(int[] nums) { // 12   72
        int length = nums.length;
        if (length < 2) {
            return 0;
        }

        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        int maxDigit = nums[0];
        for (int num : nums) {
            maxDigit = Math.max(num, maxDigit);
        }

        // 进行基数排序
        int m = 1;
        while (m <= maxDigit) {
            for (int num : nums) {
                buckets.get(num / m % 10).add(num);
            }
            int k = 0;
            for (List<Integer> bucket : buckets) {
                for (int i : bucket) {
                    nums[k++] = i;
                }
                bucket.clear();
            }
            m *= 10;
        }

        int maxGap = 0;
        for (int i = 0; i < length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }
        return maxGap;
    }

    public static int maximumGap2(int[] nums) { // 12   72
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max= num;
            }
            if (num < min) {
                min = num;
            }
        }

        // 1. 准备桶
        int range = Math.max(1, (max - min) / (length - 1));
        List<List<Integer>> buckets = new ArrayList<>((max - min)/ range + 1);
        for (int i = 0; i < (max - min)/ range + 1; i++) {
            buckets.add(new ArrayList<>());
        }
        // 2. 放入数据
        for (int num : nums) {
            buckets.get((num - min) / range).add(num);
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
        int maxGap = 0;
        for (int i = 0; i < length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }
        return maxGap;

    }
}
