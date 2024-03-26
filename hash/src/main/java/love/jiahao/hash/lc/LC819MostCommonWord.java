package love.jiahao.hash.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <big>最常见的单词</big>
 *
 * @author 13684
 * @date 2024/3/22
 */
public class LC819MostCommonWord {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }

    /*
        1. 将paragraph截取为一个个的单词
        2. 将单词放入map集合中，key为单词，value为出现的次数，避免禁用词加入
        3. 在map集合中找到value最大的取出key即可
     */
    public static String mostCommonWord(String paragraph, String[] banned) { // 13 50
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = Set.of(banned);
        for (String s : split) {
            if (!set.contains(s)) {
                map.compute(s, (key, value) -> value == null? 1: value + 1);
            }
        }

        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static String mostCommonWord2(String paragraph, String[] banned) { // 53 5
        // 1. split切分字符串效率不高，切换为自己实现的方法
        char[] charArray = paragraph.toLowerCase().toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new java.util.HashSet<>(Set.of(banned));
        set.add("");
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }else {
                String key = sb.toString();
                if (!set.contains(key)) {
                    map.compute(key, (k, v) -> v == null? 1 : v + 1);
                }
                sb = new StringBuilder();
            }
        }

        if (!sb.isEmpty()) {
            String key = sb.toString();
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null? 1 : v + 1);
            }
        }


        // 2.lamda表达式效率不高， 替换为遍历
        int max = 0;
        String s = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                s = entry.getKey();
            }
        }
        return s;
    }

}
