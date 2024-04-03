package love.jiahao.interview150.arrayAndString;

import java.util.*;

/**
 * <big>全排列-去除重复</big>
 *
 * @author 13684
 * @date 2024/3/31
 */
public class LC47PermuteUnique {
    /*
        和46一样，但是首先需要对数组进行排序，排序后相同元素会待在一起，我们让左边的先排
        如果左边相同的元素还没排，已经排到当前元素了，就直接进行下一轮循环
     */
    public List<List<Integer>> permuteUnique(int[] nums) {  // 25 84
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        doPermuteUnique(nums, new boolean[nums.length], new Stack<>(), result);
        return result;
    }

    private void doPermuteUnique(int[] nums, boolean[] visited, Stack<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                doPermuteUnique(nums, visited, stack, result);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
