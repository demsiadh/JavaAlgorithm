package love.jiahao.figure;

/**
 * <big>图的边</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class Edge {
    Vertex linked;  // 终点
    int weight;  // 权重
    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
        linked.inDegree++;
    }

    public Edge(Vertex linked) {
        this.linked = linked;
        this.weight = 1;
        linked.inDegree++;
    }

}
