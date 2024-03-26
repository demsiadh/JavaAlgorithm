package love.jiahao.interview150.arrayAndString;

/**
 * <big>最大利润</big>
 * <p>定义最小值，更有小者则交换，无则判断利润是否大于之前的利润，直到数组遍历完成</p>
 * <p>返回最大利润</p>
 *
 * @author 13684
 * @date 2024/3/15
 */
public class LC121MaxProfit {
    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;   // 较小值
        int maxProfit = 0; // 最大利润
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
