package love.jiahao.queue.priority;

/**
 * <big>优先级数据实现接口</big>
 * @author 13684
 * @date 2024/2/27
 */
public interface Priority {
    /**
     * 获取优先级
     * @return 优先级（越大越优先）
     */
    int priority();
}
