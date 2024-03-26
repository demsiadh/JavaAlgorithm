package love.jiahao.interview150.arrayAndString;

/**
 * <big>H指数</big>
 * <p>假如数组为[3, 0, 6, 1, 5],则h指数为3，标示3以上的数字至少出现三次</p>
 *
 * @author 13684
 * @date 2024/3/16
 */
public class LC274HIndex {
    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        System.out.println(hIndex(nums));

        int[] nums2 = {1, 2};
        System.out.println(hIndex(nums2));
    }


    public static int hIndex(int[] citations) {
        int length = citations.length;
        // 对数组进行排序
        sorted(citations, length - 1);
        // 从后往前遍历，每有一个大于h的h就加加，最后返回h
        int h = 0, i = length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void sorted(int[] nums, int right) {
        if (right == 0) return;
        int x = 0;
        int temp;
        for (int i = 0; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                x = i;
            }
        }
        sorted(nums, x);
    }
}
