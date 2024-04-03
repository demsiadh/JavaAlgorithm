package love.jiahao.interview150.stack;

import java.util.LinkedList;

/**
 * <big>简化路径</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC71SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/home//foo/"));
    }
    /*
        采用双端队列，首先将字符串根据/进行分隔
        遍历分割后的数组，如果不是..不是.则加入到队列尾部
        如果为..并且队列中有元素，则移除尾部目录
        遍历完成后，拼接为字符串，从头部取出
     */
    public static String simplifyPath(String path) {    // 94 50
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (s.length() > 0 && !".".equals(s)) {
                stack.offerLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        }else {
            while (!stack.isEmpty()) {
                sb.append("/").append(stack.pollFirst());
            }
        }

        return sb.toString();
    }
}
