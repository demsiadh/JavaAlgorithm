package love.jiahao.interview150.doublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>两数之和-输入有序数组</big>
 *
 * @author 13684
 * @date 2024/3/25
 */
public class LC167TwoSum {

    /*
        暴力遍历
     */
    public int[] twoSum(int[] numbers, int target) {    // 5 7
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (number + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    }
    /*
        使用map存放之前遍历的结果，占用了额外的空间，但时间上更快
        map存放 数组值 和 对应的索引
     */
    public int[] twoSum2(int[] numbers, int target) {    // 11 91
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
    /*
        双指针
        采用头尾指针，如果两数相加等于target则找到索引
        如果比target小则头指针右移一位
        比target大则尾指针左移一位
     */
    public int[] twoSum3(int[] numbers, int target) {    // 98 50
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
