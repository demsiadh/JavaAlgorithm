package love.jiahao.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>汉诺塔(递归解决)</p>
 * <p>游戏规则</p>
 * <ul>
 *     <li>abc三根柱子上只有a有圆盘，且大圆盘在下面，小圆盘在上面</li>
 *     <li>从abc三根柱子中将a柱子上的三个圆盘搬到c柱子</li>
 *     <li>一次只能移动一个圆盘，而且大圆盘必须在下面</li>
 * </ul>
 * @author 13684
 * @date 2023/11/29
 */
public class E13hanoiTower {
    // 柱子a
    static LinkedList<Integer> a = new LinkedList<>();
    // 柱子b
    static LinkedList<Integer> b = new LinkedList<>();
    // 柱子c
    static LinkedList<Integer> c = new LinkedList<>();

    public static void main(String[] args) {
        int n = 3;
        init(n);
        print();
        // T(n) = 2T(n - 1) + c
        // O(2^n)
        move(n, a, b, c);
    }

    /**
     * <p>初始化圆盘方法</p>
     * @param n   圆盘数量
     */
    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addFirst(i);
        }
    }

    /**
     * <p>打印当前所有柱子上圆盘情况</p>
     */
    static void print() {
        System.out.println("---------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * <p>移动圆盘</p>
     * <ol>
     *     <li>将步骤拆解</li>
     *     <li>其他圆盘从a移到b</li>
     *     <li>将最大的圆盘从a移到c</li>
     *     <li>将其他圆盘从b移到c</li>
     * </ol>
     * <p>除了最大的圆盘，移动其他圆盘都是调用之前的方法，所以可以使用递归</p>
     * @param n     当前圆盘数量
     * @param a     a柱子
     * @param b     b柱子
     * @param c     c柱子
     */
    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c) {
        if (n == 0) return;
        move(n - 1, a, c, b);
        c.addFirst(a.removeFirst());
        print();
        move(n - 1, b, a, c);
    }
}
