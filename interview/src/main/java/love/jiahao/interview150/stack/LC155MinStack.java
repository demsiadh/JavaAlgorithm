package love.jiahao.interview150.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * <big>最小栈</big>
 *
 * @author 13684
 * @date 2024/3/29
 */
public class LC155MinStack {    // 95 80
    /*
        使用jdk的list模拟一个栈（更适合用动态环形数组，这里没有实现就不用了）
        每次增加元素和移除元素都在list的尾部
        如果增加的元素比最小值小则更新最小值，如果删除的元素等于最小值
        则重新找最小值
     */
    List<Integer> list;
    int min;
    public LC155MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        list.add(val);
        this.min = Math.min(val, this.min);
    }

    public void pop() {
        Integer remove = list.remove(list.size() - 1);
        if (remove == this.min) {
            findMin();
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return this.min;
    }

    private void findMin() {
        int temp = Integer.MAX_VALUE;
        for (int number: list) {
            temp = Math.min(temp, number);
        }
        this.min = temp;
    }
}
