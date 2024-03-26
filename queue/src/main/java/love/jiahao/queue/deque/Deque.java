package love.jiahao.queue.deque;

/**
 * <big>双端队列实现接口</big>
 * @author 13684
 * @date 2024/1/2
 */
public interface Deque<E> extends Iterable<E> {
    /**
     * 向队列头部添加元素
     * @param e 元素
     * @return  添加结果
     */
    boolean offerFirst(E e);
    /**
     * 向队列尾部添加元素
     * @param e 元素
     * @return  添加结果
     */
    boolean offerLast(E e);

    /**
     * 移除队列头部元素
     * @return  移除的元素
     */
    E pollFirst();

    /**
     * 移除队列尾部元素
     * @return  移除的元素
     */
    E pollLast();

    /**
     * 查看队列头部元素
     * @return  查看的元素
     */
    E peekFirst();

    /**
     * 查看队列尾部元素
     * @return  查看的元素
     */
    E peekLast();

    /**
     * 队列是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 队列是否已满
     * @return 是否已满
     */
    boolean isFull();
}
