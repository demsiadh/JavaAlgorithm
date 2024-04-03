package love.jiahao.interview150.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>全排列</big>
 *
 * @author 13684
 * @date 2024/3/31
 */
public class LC46Permute {
    /*
        使用回溯思想，深度优先遍历，每次遍历时标记使用了那些数字
        回溯时将状态恢复到原来的样子，当栈中元素和数组长度一样时则进行添加结果并且递归终止

     */
    public List<List<Integer>> permute(int[] nums) {    // 96 40
        List<List<Integer>> result = new ArrayList<>();
        doPermute(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private void doPermute(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                doPermute(nums, visited, stack, result);
                stack.poll();
                visited[i] = false;
            }
        }
    }
}
