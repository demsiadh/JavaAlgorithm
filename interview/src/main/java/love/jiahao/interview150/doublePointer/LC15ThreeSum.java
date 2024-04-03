package love.jiahao.interview150.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <big>三数之和</big>
 *
 * @author 13684
 * @date 2024/3/26
 */
public class LC15ThreeSum {
    /*
            首先排序数组
        1. 从头遍历第一个节点，将目标定位当前节点的负数
        2. 开始两数之和的遍历，不采用暴力遍历而是双指针
        3. 从第一个节点的后一个开始遍历，第三个节点则有尾部开始遍历
        4. 如果三节点在二节点的右边且相加大于目标，则三节点左移
        5. 二者相等打破内层循环，相加等于目标则添加到结果
     */
    public List<List<Integer>> threeSum(int[] nums) {   // 66 34
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }

            }
        }

        return result;
    }
}
