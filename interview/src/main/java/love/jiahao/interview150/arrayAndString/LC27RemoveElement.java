package love.jiahao.interview150.arrayAndString;

import java.util.Arrays;

/**
 * <big>移除元素</big>
 * <p>记录数组长度，如果遍历到要删除的数，则不作处理，如果不是则重新赋值到数组中</p>
 * <p>最后返回数组长度</p>
 *
 * @author 13684
 * @date 2024/3/13
 */
public class LC27RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 2, 3, 4}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
