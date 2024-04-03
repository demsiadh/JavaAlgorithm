package love.jiahao.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <big>桶排序</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] ints = {2, 33, 43, 35, 47, 59, 26};
        bucketSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    /*
        1. 准备桶
        2. 将对应的数据放入同一个桶
        3. 桶内元素排序
        4. 排好序依次填入数组
        这里有个前提就是数必须是0-99仅限当前实现
     */
    private static void bucketSort(int[] nums) {
        // 1. 准备桶
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        // 2. 放入数据
        for (int num : nums) {
            buckets.get(num / 10).add(num);
        }

        int k = 0;
        for (List<Integer> bucket : buckets) {
            // 3.桶内排序
            bucket.sort(null);
            // 4. 桶内数据填入数组
            for (int num : bucket) {
                nums[k++] = num;
            }
        }
    }
}
