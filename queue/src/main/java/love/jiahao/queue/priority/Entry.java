package love.jiahao.queue.priority;

/**
 * <big>实体类</big>
 * @author 13684
 * @date 2024/2/27
 */
public class Entry<E> implements Priority{
    int priority;
    E value;

    public Entry(E value, int priority){
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "priority=" + priority +
                ", value=" + value +
                '}';
    }
}
