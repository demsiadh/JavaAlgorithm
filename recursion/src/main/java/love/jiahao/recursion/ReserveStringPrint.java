package love.jiahao.recursion;

/**
 * 递归反向打印字符串
 */
public class ReserveStringPrint {
    public static void main(String[] args) {
        handler(1, "asdsa");
    }

    private static void handler(int n, String str) {
        if (n == str.length()) return;
        handler(n + 1, str);
        System.out.println(str.charAt(n));
    }
}
