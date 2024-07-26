package love.jiahao.heap.lc;

import java.util.PriorityQueue;

/**
 * <big>力扣160题寻找数据流的中位数(Java自带的堆实现)</big>
 * <p>解题思路</p>
 * <li>用一个大顶堆存放较小值，小顶堆存放较大值</li>
 * <li>数量相等则相加/2为中位数，不相等则大顶堆的最大值为中位数</li>
 *
 * @author 13684
 * @date 2024/2/29
 */
public class LC160MedianFinder_2 {
    private final PriorityQueue<Integer> left;
    private final PriorityQueue<Integer> right;

    public LC160MedianFinder_2() {
        left = new PriorityQueue<Integer>(8, (a, b) -> Integer.compare(b, a));
        // 默认是小顶堆
        right = new PriorityQueue<Integer>(8);
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    @SuppressWarnings("all")
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else return left.peek();
    }


    public static void main(String[] args) {
        LC160MedianFinder_2 finder = new LC160MedianFinder_2();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
