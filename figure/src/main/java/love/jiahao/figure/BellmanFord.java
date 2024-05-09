package love.jiahao.figure;

import java.util.List;

/**
 * <big>贝尔曼最短距离算法-可以处理权重和为负的情况</big>
 * <p>迪克斯特拉 不行</p>
 * <p>遍历节点个数-1次，每次遍历所有节点，如果源点加上权重小于当前距离，就替换掉</p>
 *
 * @author 13684
 * @date 2024/5/9
 */
public class BellmanFord {
    public static void main(String[] args) {
        /*
        v1--(2)-->v2--(1)-->v3--(1)-->v4
          \------(-2)------/
        */
        List<Vertex> vertexList = Demo.getVertex4();
        vertexList.get(0).setDistance(0);
        // 排序数量 - 1次
        for (int i = 0; i < vertexList.size(); i++) {
            // 遍历每个节点的每条边
            for (Vertex source : vertexList) {
                for (Edge edge : source.edges) {
                    // 起点
                    Vertex e = edge.linked;
                    if (source.distance != Integer.MAX_VALUE && source.distance + edge.weight < e.distance) {
                        // 如果循环完长度——1次 还能进来就说明出现了负环
                        if (i == vertexList.size() - 1) {
                            throw new RuntimeException("出现负环");
                        }
                        e.distance = source.distance + edge.weight;
                        e.prev = source;
                    }
                }
            }
        }

        for (Vertex vertex : vertexList) {
            System.out.println(vertex.getName() + ": " + vertex.getDistance() + " " + vertex.prev);
        }
    }
}
