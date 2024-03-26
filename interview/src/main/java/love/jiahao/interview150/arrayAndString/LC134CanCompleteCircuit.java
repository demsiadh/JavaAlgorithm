package love.jiahao.interview150.arrayAndString;

/**
 * <big>加油站问题</big>
 * <p><a href="https://leetcode.cn/problems/gas-station/solutions/54278/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/?envType=study-plan-v2&envId=top-interview-150">题解</a></p>
 *
 * @author 13684
 * @date 2024/3/16
 */
public class LC134CanCompleteCircuit {

    // 剩余的油 = 剩的油 + 可获得的油 - 耗费的油
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;  // 最小的剩余油量
        int minIndex = 0; // 最小剩余油量的前一个点

        for (int i = 0; i < length; i++) {
            // 到下一站剩余的油
            spare = spare + gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        if (spare < 0) { // 剩余油量为负数则无法走完全程
            return  -1;
        } else if (minSpare >= 0) { // 最小油量为正的证明从0开始出发可以走完一圈
            return 0;
        }else { // 其他情况则表明从油量最少的那个点可以走完全程
            return (minIndex + 1) % length;
        }

    }
}
