package love.jiahao.interview150.arrayAndString;

/**
 * <big>接雨水问题</big>
 *
 * @author 13684
 * @date 2024/3/17
 */
public class LC42Trap {

    // 首先进行左遍历，求出最大能接到的雨水量 雨水量 = 当前高度和前一位能接的雨水量的最大值
    // 然后右遍历
    // 最后二者数组取最小值并减去当前高度，即为当前可接到的雨水量
    public static int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = height[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            result +=Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }

    public static int trap2(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int[] left = new int[length];
        left[0] = height[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        int right = height[length - 1];
        int result = 0;
        for (int i = length - 2; i >= 0; i--) {
            right = Math.max(right, height[i]);
            result += Math.min(right, left[i]) - height[i];
        }

        return result;
    }
}
