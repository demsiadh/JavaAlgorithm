package love.jiahao.queue;

public class ArrayQueue {
    private int maxSize; // 最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr;

    // 初始化队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // 往队列添加数据
    public Boolean add(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        arr[++rear] = n;
        return true;
    }

    // 取出队列数据
    public int get() {
        if (isEmpt()) {
            System.out.println("队列为空！");
            return -1;
        }
        return arr[++front];
    }

    // 显示队列中的所有数据
    public void show() {
        if (isEmpt()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n", i, arr[i]);
        }
    }

    // 显示队列头部数据，不是取出，就是显示
    public int head() {
        if (isEmpt()) {
            System.out.println("队列为空!");
            return -1;
        }
        return arr[front + 1];
    }

    // 查看队尾数据
    public int tail() {
        if (isEmpt()) {
            System.out.println("队列为空");
            return -1;
        }
        return arr[rear];
    }

    // 判断队列是否为空
    private boolean isEmpt() {
        return rear == front;
    }


    // 判断队列是否满了
    public Boolean isFull() {
        if (this.rear == this.maxSize - 1) {
            return true;
        }
        return false;
    }
}
