package love.jiahao.interview150.arrayAndString;

/**
 * <big>z字形变换</big>
 *
 * @author 13684
 * @date 2024/3/18
 */
public class LC6Convert {

    // 定义每一行的StringBuilder，并为其附上初值
    // 遍历字符数组，到第一行和最后一行变换方向，所以开始时flag为反向
    // 每次遍历让i加上flag来达到z字遍历
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder[] str = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = new StringBuilder();
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            str[i].append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        return String.join("", str);
    }
}
