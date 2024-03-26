package love.jiahao.queue;



import org.junit.Test;

import java.util.Scanner;

public class TestArrayQueue {
    @Test
    public void testQueue() {
        ArrayQueue queue = new ArrayQueue(3);
        // 添加数据
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("查看队列中的数据");
        queue.show();
        System.out.println("查看队列头数据" + queue.head());
        System.out.println("查看队列尾数据" + queue.tail());

        System.out.println("获取队列数据" + queue.get());
        System.out.println("查看队列中的数据");
        queue.show();
    }

    public static void main(String[] args) {
        // 为了测试方便直接写成一个控制台小程序
        CircleQueue queue = new CircleQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' '; // 接受用户输入指令
        while (loop) {
            System.out.println("-----------------------");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("t(tail): 查看队列尾的数据");
            System.out.println("p(isEmpty): 队列是否为空");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' -> queue.show();
                case 'e' -> loop = false;
                case 'a' -> {
                    System.out.println("请输入要添加到队列的整数：");
                    int value = scanner.nextInt();
                    queue.add(value);
                }
                case 'g' -> {
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 'h' -> System.out.printf("头数据是：%d\n", queue.head());
                case 't' -> System.out.printf("尾数据是：%d\n", queue.tail());
                case 'p' -> System.out.println(queue.isEmpty());
            }
        }
    }

    @Test
    public void test() {
        int c = 30;
        // 减一是为了防止刚好是2的指数次幂
        c-=1;
        // 右移再进行位或运算是为了得出从最高到最低位都是1的数，这时的结果再加一，就可以得出我们想要的二次幂的数
        // 1+2+4+8+16=31刚好是int类型的位数（不包含首位符号位），所以可以做到求最近的2的指数幂的数
        c|=c>>1;
        c|=c>>2;
        c|=c>>4;
        c|=c>>8;
        c|=c>>16;
        c+=1;
        System.out.println(c);
    }
}
