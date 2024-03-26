package love.jiahao.queue;

import java.util.Iterator;

/**
 * <big>环形数组实现队列4</big>
 * <p>假如除数是2的整数倍就可以直接右移相对的整数位置来求商</p>
 * <p>对除数-1按位与就可以求余数</p>
 * <p>顺便解决边界问题(head或者tail越界的问题)</p>
 * <p>因为数组的长度最大也是2^31 - 1</p>
 * <p>按位也是31位与，也求不到负数，解决了这个问题</p>
 * <p>而且位运算效率更高</p>
 * @author 13684
 * @date 2023/12/8
 */
public class CircleArrayQueue4<E> implements Queue<E>, Iterable<E>{
    private final E[] array;      // 数组
    private int head = 0;   // 头指针
    private int tail = 0;   // 尾指针

    @SuppressWarnings("all")
    // 需要保证数组容量为2的倍数
    public CircleArrayQueue4(int capacity) {
        // 方法一：如果传入的不是2的倍数，就直接抛出异常
        //if ((capacity & capacity - 1) != 0) throw new IllegalArgumentException("capcity 必须是2的幂");

        // 方法二：找到比他大的2的次幂赋值给容量
        // 如果传入的本来就是2的幂就先把传入的减一再进行求对数，这里用了换底公式因为Java没有log2
        // 将得出的指数，对1进行左移就可得到容量
        //capacity = 1 << (int) ((Math.log10(capacity - 1) / Math.log10(2)) + 1);

        // 方法三：位或运算

        // 减一是为了防止刚好是2的指数次幂
        capacity-=1;
        // 右移再进行位或运算是为了得出从最高到最低位都是1的数，这时的结果再加一，就可以得出我们想要的二次幂的数
        // 1+2+4+8+16=31刚好是int类型的位数（不包含首位符号位），所以可以做到求最近的2的指数幂的数
        capacity|=capacity>>1;
        capacity|=capacity>>2;
        capacity|=capacity>>4;
        capacity|=capacity>>8;
        capacity|=capacity>>16;
        capacity+=1;
        array = (E[]) new Object[capacity];
    }
    @SuppressWarnings("all")
    public CircleArrayQueue4() {
        array = (E[]) new Object[16];
    }

    @Override
    public Iterator<E> iterator() { 
        return new Iterator<>() {
            int temp = head;
            @Override
            public boolean hasNext() {
                return temp != tail;
            }

            @Override
            public E next() {
                E e = array[temp & (array.length - 1)];
                temp++;
                return e;
            }
        };
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail & (array.length - 1)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E e = array[head & (array.length - 1)];
        head++;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head & (array.length - 1)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }
}
