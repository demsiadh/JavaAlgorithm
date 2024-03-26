package love.jiahao.recursion;

/**
 * <h2>递归爆栈问题</h2>
 */
public class E12Sum {
    public static void main(String[] args) {
        System.out.println(handler2(100));
        System.out.println(handler2(30_000));
    }

    /**
     * <h3>递归求和</h3>
     * <p>1+2+3+...+n</p>
     * @param n     加到多少
     * @return      结果
     */
    private static int handler(int n) {
        if (n >= 0) return n + handler(n - 1);
        return 0;
    }

    /**
     * <h3>循环(解决爆栈)</h3>
     * <p>1+2+3+...+n</p>
     * @param n     加到多少
     * @return      结果
     */
    private static int handler2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

}
// Scala中做了尾递归的优化，只要函数最后一行只是函数调用，在编译中就可以平级调用，防止爆栈
// object Main {
//
//        def main(args: Array[String]): Unit = {
//        //    println("Hello, Scala")
//        println(sum(3, 0)) // 6
//        }
//
//@tailrec
//  def sum(n: Long, accumulator: Long): Long = {
//          if (n == 1) {
//          return 1 + accumulator
//          }
//          return sum(n - 1, n + accumulator)
//          }
//
//  /*
//  sum(n=3, accumulator=0): Long = {
//    return sum(2, 3)
//  }
//  sum(n=2, accumulator=3): Long = {
//    return sum(1, 5)
//  }
//  sum(n=1, accumulator=5): Long = {
//    if (n == 1) {
//      return 1 + 5
//    }
//  }
//   */
//
//          }

