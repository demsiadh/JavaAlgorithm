package love.jiahao.hot;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/26 上午9:39
 */
public class LC49Trap {
    /**
     * 首先通过左遍历找到左边的最大值
     * 然后通过右遍历找到右边的最大值
     * 然后通过两值之间的最小值减去当前值计算接到雨水的量
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 1) {
            return 0;
        }
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
