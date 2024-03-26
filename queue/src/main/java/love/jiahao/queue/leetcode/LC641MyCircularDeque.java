package love.jiahao.queue.leetcode;

/**
 * <big>力扣641题设计循环双端队列</big>
 * <p>数组实现</p>
 * @author 13684
 * @date 2024/2/27
 */
public class LC641MyCircularDeque {
    // 数组
    int[] array;
    // 元素个数
    int size;
    // 头
    int head;
    // 尾
    int tail;

    /**
     * 有参构造函数
     * @param k 最大容量
     */
    public LC641MyCircularDeque(int k) {
        array = new int[k];
        head = tail = 0;
        size = 0;
    }

    /**
     * 往队列头插入值
     * @param value 要插入的值
     * @return 插入结果
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = subIndex(head);
        array[head] = value;
        size++;
        return true;
    }

    /**
     * 往队列尾添加值
     * @param value 要添加的值
     * @return 插入结果
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = addIndex(tail);
        size++;
        return true;
    }

    /**
     * 从队列头部删除一个元素
     * @return 删除结果
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        array[head] = 0;
        head = addIndex(head);
        size--;
        return true;
    }

    /**
     * 从队列尾部删除一个元素
     * @return 删除结果
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = subIndex(tail);
        array[tail] = 0;
        size--;
        return true;
    }

    /**
     * 从队列头部获取元素
     * @return 获取的元素值
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return array[head];
    }

    /**
     * 从队列尾部获取元素
     * @return 获取的元素值
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return array[subIndex(tail)];
    }

    /**
     * 判断队列是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断队列是否为满
     * @return 是否为满
     */
    public boolean isFull() {
        return size == array.length;
    }

    private int subIndex(int index) {
        return (index - 1 + array.length) % array.length;
    }

    private int addIndex(int index) {
        return (index + 1) % array.length;
    }
}
