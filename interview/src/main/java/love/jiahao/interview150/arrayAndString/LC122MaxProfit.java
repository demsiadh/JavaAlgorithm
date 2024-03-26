package love.jiahao.interview150.arrayAndString;

/**
 * <big>最大利润2</big>
 * <p>递增时计算利润，递减时将利润累积起来，并重新给最小值赋值</p>
 *
 * @author 13684
 * @date 2024/3/15
 */
public class LC122MaxProfit {
    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints));

        int[] ints1 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(ints1));

        int[] ints2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(ints2));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        int countProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] < prices[i]) {
                minPrice = prices[i + 1];
                if (maxProfit > 0) {
                    countProfit += maxProfit;
                    maxProfit = 0;
                }
            }else {
                maxProfit = prices[i + 1] - minPrice;
            }
        }
        countProfit += maxProfit;
        return countProfit;
    }
}
