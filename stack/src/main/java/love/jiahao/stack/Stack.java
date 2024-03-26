package love.jiahao.stack;

/**
 * <big>栈的统一接口-自己定义的</big>
 *
 * @author 13684
 * @date 2023/12/10
 */
public interface Stack<E> {
    /**
     * <p>压栈-往栈顶添加元素</p>
     *
     * @param value 元素
     * @return 添加结果
     */
    boolean push(E value);

    /**
     * <p>弹栈-将栈顶的元素弹出栈</p>
     *
     * @return 弹出的元素
     */
    E pop();

    /**
     * <p>查看栈顶的元素</p>
     *
     * @return 栈顶的元素
     */
    E peek();

    /**
     * <p>栈是否为空</p>
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * <p>栈是否为满</p>
     *
     * @return 是否为满
     */
    boolean isFull();
}
