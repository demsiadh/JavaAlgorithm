package love.jiahao.heap;

/**
 * <big></big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/24 上午10:58
 */
public class LC11MaxArea {
    /**
     * 因为接到的水其实是受最低的那个影响的，高的决定不了
     * 所以采用双指针，在两头进行处理，移动较小的指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0,temp = 0, max = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] > height[right]) {
                temp = height[right] * (right - left);
                right--;
            }else {
                temp = height[left] * (right - left);
                left++;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
