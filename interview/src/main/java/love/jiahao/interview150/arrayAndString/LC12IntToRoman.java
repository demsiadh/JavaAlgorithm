package love.jiahao.interview150.arrayAndString;

/**
 * <big>整数数转罗马字</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC12IntToRoman {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    // 直接列举出所有情况，从头开始遍历，如果大于数字就转为罗马数字，直到数字为0
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value) {
                num -=value;
                result.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }

        return result.toString();
    }
}
