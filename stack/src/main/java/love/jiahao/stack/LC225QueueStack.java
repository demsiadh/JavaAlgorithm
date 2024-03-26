package love.jiahao.stack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <big>力扣225题-使用队列模拟栈</big>
 * @author 13684
 * @date 2023/12/11
 */
public class LC225QueueStack {

    LinkedList<Integer> queue = new LinkedList<>();
    public LC225QueueStack() {

    }

    /**
     * <p>往队列添加元素，我们需要把队列之前的元素，全部移除，再重新加到队列</p>
     * <p>例如 1 2 添加 3 -> 3 1 2</p>
     * @param x 添加的元素
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * <p>弹出栈，因为添加元素的时候已经做了反转，所以可以直接弹出</p>
     * @return  弹出元素
     */
    public int pop() {
        if (queue.isEmpty()) throw new RuntimeException();
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) throw new RuntimeException();
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
