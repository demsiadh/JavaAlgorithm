package love.jiahao.interview150.doublePointer;

/**
 * <big>盛水最多的容器</big>
 *
 * @author 13684
 * @date 2024/3/25
 */
public class LC11MaxArea {

    /*
        采用双指针，每次计算当前盛水量
        哪边低就往另一边靠
        最后返回成水量的最大值
     */
    public int maxArea(int[] height) {  // 96 60
        int left = 0, max = 0, right = height.length - 1;
        int temp;
        while (left < right) {
            if (height[left] > height[right]) {
                temp = height[right] * (right - left);
                right--;
            }else {
                temp = height[left] * (right - left);
                left++;
            }

            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }
}
