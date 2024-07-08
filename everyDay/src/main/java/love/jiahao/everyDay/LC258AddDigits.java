package love.jiahao.everyDay;

/**
 * <big>力扣 258. 各位相加</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/7/8 下午2:09
 */
public class LC258AddDigits {
    /**
     * 暴力解法
     * <p>求出各位之和，然后交换和和num，进行下一次循环，直到结果小于10为止</p>
     * @param num 数字
     * @return 各位之和
     */
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    /**
     * 由于是求一直到各位数的和，所以直接余9映射到 0-8 区间中
     * 由于需要个位数，所以需要对区间进行+1来映射到 0 - 9 区间中（0为特殊情况）
     * 考虑到个位数的情况和本身为9的倍数，所以需要先把数组减一，在进行余9操作
     * @param num 需要操作的数
     * @return  操作结果
     */
    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
