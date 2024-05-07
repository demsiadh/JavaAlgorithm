package love.jiahao.figure;

import java.util.List;

/**
 * <big>图的顶点</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class Vertex {
    String name; // 名字
    List<Edge> edges; // 边
    boolean visited; // 是否访问过 DFS BFS
    int inDegree; // 入度
    int status; // 0-未访问 1-访问中 2-访问过
    int distance = Integer.MAX_VALUE; // 距离 默认为最大值

    Vertex prev; // 上一个节点

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
