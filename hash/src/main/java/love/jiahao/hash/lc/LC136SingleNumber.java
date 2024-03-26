package love.jiahao.hash.lc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <big>只出现一次的数字</big>
 * <p>只有一个元素只出现一次，其余都出现两次</p>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC136SingleNumber {
    /*
        1. 创建一个set集合
        2. 遍历数组，如果集合中有则删除，没有则新加
        3. 最后集合剩的就是出现一次的数字
     */
    public int singleNumber(int[] nums) { // 19 84
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    /*
        依次对每个元素进行异或运算，最后的值即为唯一值
        前提:     1.题目说了相同的只会出现两次，不同出现一次
                 2.相同的数异或之后是0 任何数和0异或是自己本身
                 3.异或支持交换律
                 4.题目说明数组至少有一个元素
        例子： 4 1 2 1 2
        1和1异或为0 0和2异或为2 2和2异或为0 0和4异或为4
     */
    public int singleNumber2(int[] nums) { // 94 65
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }

        return num;
    }
}
