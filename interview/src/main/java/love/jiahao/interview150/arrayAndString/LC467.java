package love.jiahao.interview150.arrayAndString;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/6/24
 */
public class LC467 {
    public static void main(String[] args) {

    }

    /**
     * 检查循环数组中是否存在循环。
     * 循环数组是指数组中的一些元素可以形成一个循环，即通过数组中的某些元素的索引值和对应的元素值可以回到起点。
     * 此方法通过 Floyd 的 tortoise and hare 算法来检测循环。
     *
     * @param nums 输入的整数数组，假设该数组长度大于等于 2。
     * @return 如果存在循环则返回 true，否则返回 false。
     */
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        // 遍历数组，检查每个可能的起始点是否存在循环
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 使用 Floyd 算法检查循环
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    // 如果 slow 和 fast 相遇，检查是否为有效循环
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 如果没有找到循环，将当前起始点标记为 0，以避免后续再次检查
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int temp = add;
                add = next(nums, add);
                nums[temp] = 0;
            }
        }
        // 如果没有找到任何循环，则返回 false
        return false;
    }

    /**
     * 计算数组中下一个位置的索引。
     * 考虑到数组可能是循环的，此方法通过取模操作来计算下一个位置。
     *
     * @param nums 输入的整数数组。
     * @param i 当前元素的索引。
     * @return 下一个元素的索引。
     */
    private static int next(int[] nums, int i) {
        int l = nums.length;
        // 防止负数取模的结果是负数
        return ((i + nums[i]) % l + l) % l;
    }

}
