package love.jiahao.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;   // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};    // 防止创建了不用占用空间，一开始就创建一个空数组

    // 添加元素到结尾
    public void addLast(int element) {
        // array[size] = element;
        // size++;
        add(size, element);
    }
    // 1 2 3 5 6 7  2 6
    // 0 1 2 3 4 5

    // 1 2 6 3 5 6 7
    // 0 1 2 3 4 5 6
    // 指定索引添加元素
    // 在头部和中间位置插入或删除元素都涉及到元素的移动，时间复杂度就是O(n)
    // 在尾部就是O(1) 当然这只是均摊的情况
    public void add(int index, int element) {
        checkAndGrow();

        if (index < 0 || index > size) {
            return;
        }
        // 向后挪动，腾出位置
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    // 进行数组的容量检查
    private void checkAndGrow() {
        // 第一次给数组中添加元素时，再把数组空间创建出来
        if (size == 0){
            array = new int[capacity];
        }

        // 容量检查
        if (size == capacity) {
            // 进行扩容到1.5倍
            capacity += capacity >> 1;
            // 创建一个新的数组
            int[] newArray = new int[capacity];
            // 将原数组内容拷贝到新数组中
            System.arraycopy(array, 0, newArray, 0, size);
            // 将原数组的地址指向新的地址
            array = newArray;

        }
    }

    // 拿到指定索引元素
    // 时间复杂度由于数组的特殊性根据索引查找就是O(1)
    public int get(int index) {
        return array[index];
    }

    // 遍历数组
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    // 迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {  // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    // 流遍历
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    // 删除元素(根据索引)
    public int remove(int index) {
        // 假设索引位置有效[0, size)
        int removed = array[index];
        // 排除删除最后一个元素的情况(因为此时复制数组没有意义)
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
