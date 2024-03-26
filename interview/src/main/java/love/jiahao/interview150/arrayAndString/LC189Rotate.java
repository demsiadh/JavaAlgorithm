package love.jiahao.interview150.arrayAndString;

import java.util.Arrays;

/**
 * <big>轮转数组</big>
 * <p>新建一个数组，重新排位即可</p>
 *
 * @author 13684
 * @date 2024/3/15
 */
public class LC189Rotate {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        rotate(ints, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(ints, 0, nums, 0, nums.length);
    }
}
