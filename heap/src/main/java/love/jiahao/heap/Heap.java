package love.jiahao.heap;

/**
 * <big>自定义堆接口</big>
 * @author 13684
 * @date 2024/2/28
 */
public interface Heap {
    /**
     * 建堆
     */
    void heapify();

    /**
     * 取出堆顶元素
     * @return 堆顶元素
     */
    int poll();

    /**
     * 取出指定索引位置的元素
     * @param index 索引
     * @return 指定元素
     */
    int poll(int index);

    /**
     * 观看堆顶元素
     * @return 元素
     */
    int peek();

    /**
     * 替换堆顶元素
     * @param replaced 替换为的元素
     */
    void replace(int replaced);

    /**
     * 往堆的尾部添加元素
     * @param offered 元素
     * @return 添加结果
     */
    boolean offer(int offered);

    /**
     * 判断堆是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 判断堆是否为满
     * @return 是否满
     */
    boolean isFull();
}
