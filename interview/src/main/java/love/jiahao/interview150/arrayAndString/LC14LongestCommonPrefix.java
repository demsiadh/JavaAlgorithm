package love.jiahao.interview150.arrayAndString;

/**
 * <big>最长公共前缀</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC14LongestCommonPrefix {

    // 先假定数组第一位元素为前缀
    // 遍历数组元素，如果数组元素长度小于暂定前缀，则截取暂定前缀，并遍历这个值
    // 如果有不同，则直接在相应的位置截取，如果前缀长度小于零则返回，不为零就遍历到数组结束
    public String longestCommonPrefix(String[] strs){
        String pre = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++) {
            String str = strs[i];
            int preLength = pre.length();
            if (str.length() < preLength) {
                preLength = str.length();
                pre = pre.substring(0, preLength);
            }
            for (int j = 0; j < preLength; j++) {
                if (pre.charAt(j) != str.charAt(j)) {
                    pre = pre.substring(0, j);
                    break;
                }
            }
            if (preLength == 0) {
                return pre;
            }
        }
        return pre;
    }
}
