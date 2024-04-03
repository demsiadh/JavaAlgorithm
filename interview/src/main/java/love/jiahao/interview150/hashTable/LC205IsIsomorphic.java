package love.jiahao.interview150.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * <big>同构字符串</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC205IsIsomorphic {
    /*
        创建两个hashmap
        将第一个字符串的各个字符为key 相应位置的t的字符作为value
        如果集合中包含了当前key但是对应的不是当前t的字符就返回false
        因为这样就是前后对应不一致了

        --------------------------
        说白了就是前后对应不一样的就是返回false
     */
    public boolean isIsomorphic(String s, String t) { // 24 50
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar) && sMap.get(sChar) != tChar || tMap.containsKey(tChar) && tMap.get(tChar) != sChar) {
                return false;
            }

            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }

        return true;
    }
}
