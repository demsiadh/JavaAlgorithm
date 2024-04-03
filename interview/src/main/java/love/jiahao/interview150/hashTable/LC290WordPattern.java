package love.jiahao.interview150.hashTable;

import java.util.*;

/**
 * <big>单词规律</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC290WordPattern {
    /*
        首先以空格分割目标字符串，如果目标字符串和模板字符串不一样长则返回false
        1. 遍历字符串，将模板字母作为key，字符串作为value加入到map中
        2. 如果map中存在当前模板，又与map中的字符串不一样，返回false
        3. 如果最后map中的value存在重复元素，也就证明有两个模板对应同一个字符串，返回false
     */
    public boolean wordPattern(String pattern, String s) { // 85 74
        String[] split = s.split(" ");
        int length = split.length;
        if (length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            String str = split[i];
            if (map.containsKey(c) && !map.get(c).equals(str)) {
                return false;
            }

            map.put(c, str);
        }
        Set<String> set = new HashSet<>(map.values());

        return set.size() == map.size();
    }
}
