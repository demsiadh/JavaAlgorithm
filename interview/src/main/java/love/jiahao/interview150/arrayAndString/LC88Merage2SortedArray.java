package love.jiahao.interview150.arrayAndString;

import java.util.Arrays;

/**
 * <big>力扣88题-改版</big>
 * <p>因为数组递增，所以倒着遍历，谁的数大从后往前排</p>
 * @author 13684
 * @date 2023/12/1
 */
public class LC88Merage2SortedArray {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
        merge(a1, 0, 2, 3, 6, a2);
        System.out.println(Arrays.toString(a2));
    }
    private static void merge(int[] a1, int i, int iEnd,int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            }
            else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        if (j > jEnd) System.arraycopy(a1, i, a2, k, iEnd - i + 1);
    }

    private static void merge(int[] a1, int i, int iEnd,int j, int jEnd, int[] a2, int k) {
        if (i == iEnd) {
            while (jEnd != j) {
                a2[k] = a1[j];
                j++;
                k++;
            }
            return;
        }
        if (j == jEnd) {
            while (iEnd != i) {
                a2[k] = a1[i];
                k++;
                i++;
            }
            return;
        }

        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        }else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }
}
