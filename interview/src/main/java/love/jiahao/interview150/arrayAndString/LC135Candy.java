package love.jiahao.interview150.arrayAndString;

/**
 * <big>分发糖果</big>
 *
 * @author 13684
 * @date 2024/3/16
 */
public class LC135Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] result = new int[length];
        // 左规则 左边小
        // 得到应该分配糖果的数量
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }

        // 右规则 右边小
        // 对左右结果取最大值就是该点要分配的糖果数量
        int rigth = 0, ret = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                rigth++;
            }else {
                rigth = 1;
            }
            ret += Math.max(result[i], rigth);
        }
        return ret;
    }
}
