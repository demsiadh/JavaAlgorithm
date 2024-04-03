package love.jiahao.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <big>基数排序</big>
 *
 * @author 13684
 * @date 2024/3/28
 */
public class RadixSort {
    public static void main(String[] args) {
        String[] strs = new String[]{"12578254689", "31637892617", "13478912345"};
        radixSort(strs);
        System.out.println(Arrays.toString(strs));
    }
    /*
        按位排序(位数要相等,可以补0)
        加入字母也不碍事可以用ascii码进行排序
        1. 首先创建十个桶
        2. 其次对要排序的数进行遍历，从个位，十位，百位...进行排序
        3. 每次将结果放入数组中
        4. 遍历完成后即完成了排序
     */
    private static void radixSort(String[] a) {
        List<List<String>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        int length = a[0].length();
        for (int i = length - 1; i >= 0; i--) {
            for (String s : a) {
                buckets.get(s.charAt(i) - '0').add(s);
            }

            int k = 0;
            for (List<String> bucket : buckets) {
                for (String s : bucket) {
                    a[k++] = s;
                }
                bucket.clear();
            }
        }
    }
}
