package love.jiahao.sort.lc;

/**
 * <big>数组的相对排序</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class LC1122RelativeSortArray {

    /*
        由于数组二在数组一中都能找到所以这里采用计数排序
        首先将数组一的数字全部进行计数
        其次遍历数组二，将数组二有的元素全部填入到数组一中，直到对应的元素计数为0
        最后将剩余的计数填入数组后面排序完成
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {    // 100 63
        int max = arr1[0];
        int min = arr1[0];
        for (int i : arr1) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int[] count = new int[max - min + 1];
        for (int i : arr1) {
            count[i - min]++;
        }
        int k = 0;
        for (int number : arr2) {
            while (count[number - min] > 0) {
                arr1[k++] = number;
                count[number - min]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[k++] = i + min;
                count[i]--;
            }
        }
        return arr1;
    }
}
