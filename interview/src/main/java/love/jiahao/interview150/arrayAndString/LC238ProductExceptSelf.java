package love.jiahao.interview150.arrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>除自身以外数组的乘积</big>
 * <p>不能使用除法，尽量时间复杂度和空间复杂度O(n)</p>
 *
 * @author 13684
 * @date 2024/3/16
 */
public class LC238ProductExceptSelf {

    // 左右乘积列表法
    // 准备两个数组，分别为左边乘积和右边乘积
    // 左乘积的0号位置初始化为1，右乘积的最后一个位置初始化为1
    // 为两个数组进行赋值，遍历原始数组，头遍历，原始数组和左乘积计算乘积填入左乘积下一个位置
    // 尾遍历类似解法填入右乘积
    // 最后返回结果数组，结果数组的每一个元素等于 = 左乘积数组相应位置元素 * 右乘积数组响应位置元素
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] rigth = new int[length];
        int[] result = new int[length];
        left[0] = rigth[length - 1] = 1;
        for (int i = 0; i < length - 1; i++) {
            left[i + 1] = nums[i] * left[i];
        }

        for (int i = length - 1; i > 0 ; i--) {
            rigth[i - 1] = nums[i] * rigth[i];
        }

        for (int i = 0; i < length; i++) {
            result[i] = left[i] * rigth[i];
        }

        return result;
    }

    // 左右乘积法改进版
    // 用一个整数来代替右侧元素的乘积
    // 同时直接将左侧乘积数组当成结果数组进行运算
    // 推荐这种方法ll
    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 0; i < length - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }


        int right = 1; // 右侧元素乘积
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
