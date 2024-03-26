package love.jiahao.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * <big>测试数组实现栈</big>
 * @author 13684
 * @date 2023/12/10
 */
public class ArrayStackTest {
    private final ArrayStack<Integer> stack = new ArrayStack<>(3);

    @Before
    public void init() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.push(1));
    }

    @Test
    public void test() {
        stack.forEach(System.out::println);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.forEach(System.out::println);
    }
}
