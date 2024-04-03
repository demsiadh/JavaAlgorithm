package love.jiahao.interview150.hashTable;

import java.util.*;

/**
 * <big>快乐数</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC202IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(28));
        System.out.println(isHappy(2));
        System.out.println(isHappy(1));
    }

    /*
        使用hashset记录出现的数字，
        如果循环回来则直接返回false
        如果得到和为1则返回true
     */
    public static boolean isHappy(int n) {  // 81 47
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (!set.contains(n)) {
            set.add(n);
            sum = getDigitsSum(n);
            if (sum == 1) {
                return true;
            }
            n = sum;
        }

        return false;
    }

    private static int getDigitsSum(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
}
