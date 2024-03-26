package love.jiahao.queue.block;

/**
 * <big>阻塞队列接口</big>
 * @author 13684
 * @date 2024/2/28
 */
public interface BlockingQueue<E> {
    /**
     * 添加元素
     * @param e 要添加的值
     * @throws InterruptedException 异常
     */
    void offer(E e) throws InterruptedException;

    /**
     * 添加元素（有时间限制）
     * @param e 元素
     * @param timeout 毫秒值
     * @return  添加结果
     * @throws InterruptedException 异常
     */
    boolean offer (E e, long timeout) throws InterruptedException;

    /**
     * 取出元素
     * @return 元素值
     * @throws InterruptedException 异常
     */
    E poll() throws InterruptedException;

    /**
     * 取出元素（有时间限制）
     * @param timeout 毫秒值
     * @return 取出的元素
     * @throws InterruptedException 异常
     */
    E poll(long timeout) throws InterruptedException;
}
