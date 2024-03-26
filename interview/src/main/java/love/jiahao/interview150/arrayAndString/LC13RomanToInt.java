package love.jiahao.interview150.arrayAndString;

import java.util.HashMap;

/**
 * <big>罗马数字转整数</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC13RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    // 将每个字符串对应的值进行封装
    // 从后往前遍历字符串
    // 如果前一个字符串对应的值，比后面的大 则进行的为减法，而不是加法
    // 直到遍历到字符串的头部
    public static int romanToInt(String s) {
        int result = 0;
        int temp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = getValue(s.charAt(i));
            if (temp > num) {
                result -= num;
            }else {
                result += num;
            }
            temp = num;
        }

        return result;
    }

    // 正向遍历法
    public static int romanToInt2(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int num = getValue(s.charAt(i));
            if (num >= getValue(s.charAt(i + 1))) {
                result += num;
            }else {
                result -= num;
            }
        }
        return result + getValue(s.charAt(s.length() - 1));
    }

    public static int getValue(char s){
        switch (s){
            case 'I' -> {
                return 1;
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                return 10;
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                return 100;
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
            default -> {
                return 0;
            }
        }
    }
}
