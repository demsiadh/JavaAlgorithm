package love.jiahao.everyDay;

/**
 * <big>力扣61：温度趋势</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/21 上午9:59
 */
public class LC61TemperatureTrend {
    /**
     * 采用双指针解法，因为已知输入数组长度相等
     * 直接进行遍历，分别计算两个数组的差值，如果符合情况则增加中间值，不符合则更新最大值并重置中间值
     * 最后防止没有更新最大值，最后返回二者最大值
     * @param temperatureA  数组1
     * @param temperatureB  数组2
     * @return  最大的温度趋势相等连续天数
     */
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int slow = 0;
        int quick = 1;
        int result = 0;
        int temp = 0;
        while (quick < temperatureA.length) {
            int i = temperatureA[quick] - temperatureA[slow];
            int j = temperatureB[quick] - temperatureB[slow];
            if (i == j || (i > 0 && j > 0) || (i < 0 && j < 0)) {
                temp++;
            } else {
                result = Math.max(temp, result);
                temp = 0;
            }
            slow++;
            quick++;
        }
        return Math.max(temp, result);
    }
}
