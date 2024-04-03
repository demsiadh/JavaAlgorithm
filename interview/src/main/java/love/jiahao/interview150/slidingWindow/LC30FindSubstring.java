package love.jiahao.interview150.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <big>串联所有单词子串</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC30FindSubstring {
    public static void main(String[] args) {

    }
    /*
        暴力遍历法 -- 会超时
        遍历每一次的可能，如果相等就留下start
     */
    public static List<Integer> findSubstring(String s, String[] words) { // 超时
        int sLength = s.length();
        int wLengeth = words.length;
        int gap = words[0].length();
        int temp;
        List<Integer> list = new ArrayList<>();

        for (int start = 0, end = wLengeth * gap; end <= sLength; start++, end++) {
            List<String> tempList = Arrays.stream(words).collect(Collectors.toList());
            temp = start;
            for (int i = 0; i < wLengeth; i++, temp += gap) {
                String substring = s.substring(temp, temp + gap);
                tempList.remove(substring);
            }
            if (tempList.size() == 0) {
                list.add(start);
            }
        }
        return list;
    }
}
