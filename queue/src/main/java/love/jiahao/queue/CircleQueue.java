package love.jiahao.queue;

public class CircleQueue {
    // 队列的第一个元素
    private int front;
    // 队列的最后一个元素的下一个位置
    private int rear;
    // 数组模拟队列
    private final int[] arr;
    // 容量
    private int maxSize;

    // 构造函数
    public CircleQueue(int maxSize) {
        this.arr = new int[maxSize];
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
    }

    // 往队列里面添加数据
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满!");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 取出第一个数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }

        int n = arr[front];
        front = (front + 1) % maxSize;
        return n;
    }

    // 查看队列所有数据
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        int value = front;
        while (!isEmpty()) {
            System.out.printf("arr[%d] = %d \n", front, arr[front]);
            front = (front + 1) % maxSize;
        }
        front = value;
    }

    // 显示队列头部数据，不是取出，是显示
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }

    // 显示队列尾部数据，不是取出，是显示
    public int tail () {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return rear - 1 < 0? arr[maxSize - 1] : arr[rear - 1];
    }


    // 判断队列是否为空
    public Boolean isEmpty() {
        return rear == front;
    }

    // 判断队列是否为满
    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 队列有效个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }
}
