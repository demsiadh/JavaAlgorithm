package love.jiahao.stack;

/**
 * <big>力扣232题-使用栈实现队列</big>
 * <p>思路：使用两个栈，一个为队列头，一个为队列尾</p>
 * @author 13684
 * @date 2023/12/11
 */
public class LC232StackQueue {
    private final ArrayStack<Integer> s1 = new ArrayStack<>(100);
    private final ArrayStack<Integer> s2 = new ArrayStack<>(100);

    public LC232StackQueue() {
    }

    /**
     * <p>在队列尾新增</p>
     * @param x 新增的元素
     */
    public void push(int x) {
        s2.push(x);
    }

    /**
     * <p>出队就是如果队列头有元素就出队列头</p>
     * <p>如果没有就把队列尾的元素全部压入队列头</p>
     * <p>最后出队</p>
     * @return  弹出结果
     */
    public int pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
