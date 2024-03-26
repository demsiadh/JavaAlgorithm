package love.jiahao.queue;

/**
 * <big>队列接口</big>
 * <p>用来做不同的队列实现</p>
 * @author 13684
 * @date 2023/12/6
 */
public interface Queue<E> {
    /**
     * <p>向队尾插入值</p>
     * @param value     待插入值
     * @return          插入结果
     */
    boolean offer(E value);

    /**
     * <p>从队列头获取值，并移除</p>
     * @return      获取的值
     */
    E poll();

    /**
     * <p>从队列头获取值，不移除</p>
     * @return      获取的值
     */
    E peek();

    /**
     * <p>检查队列是否为空</p>
     * @return      是否为空
     */
    boolean isEmpty();

    /**
     * <p>检查队列是否已满</p>
     * @return  是否满
     */
    boolean isFull();
}
