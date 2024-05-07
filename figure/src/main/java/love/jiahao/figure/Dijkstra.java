package love.jiahao.figure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * <big>迪克斯特拉 单源最短路径算法</big>
 *
 * @author 13684
 * @date 2024/5/7
 */
public class Dijkstra {
    public static void main(String[] args) {
     /*
         /--(14)-->6-------(9)-------\
        1--(7)-->2--(15)-->\          5
         \--(9)-->3--(11)-->4--(6)-->/
         附 3 --(2)-->6
      */
        List<Vertex> vertexList = Demo.getVertex1();
        dijkstra(vertexList, vertexList.get(0));
    }

    /**
     * 算法实现
     * @param vertexList 顶点集合
     * @param vertex 起点 也就是源点
     */
    private static void dijkstra(List<Vertex> vertexList, Vertex vertex) {
        // 1.将所有顶点存入集合中去
        ArrayList<Vertex> unVisited = new ArrayList<>(vertexList);
        // 2.将起点的距离设置为0
        vertex.setDistance(0);

        while (!unVisited.isEmpty()) {
            // 3. 选取当前顶点 (距离最小的当顶点)
            Vertex temp = chooseMinDistVertex(unVisited);
            // 4. 更新当前顶点邻居距离
            updateNeighborDist(temp);
            // 5. 移除当前顶点
            unVisited.remove(temp);
            // 5. 将当前节点标记为访问过
            temp.visited = true;
        }

        for (Vertex vertex1 : vertexList) {
            System.out.println(vertex1.name + "-->" + vertex1.distance + "-->" + vertex1.prev);
        }
    }

    private static void updateNeighborDist(Vertex temp) {
        // 遍历每一个邻居，如果距离加上权重小于当前的距离就更新距离值
        for (Edge edge : temp.edges) {
            Vertex n = edge.linked;
            int dist = temp.distance + edge.weight;
            if (!n.visited &&  dist < n.distance) {
                n.prev = temp;
                n.setDistance(dist);
            }
        }
    }

    private static Vertex chooseMinDistVertex(ArrayList<Vertex> unVisited) {
        Optional<Vertex> minVertex = unVisited.stream().min(Comparator.comparingInt(Vertex::getDistance));
        // 处理unVisited为空的情况，返回null或抛出自定义异常
        // 或抛出new IllegalArgumentException("unVisited is empty");
        return minVertex.orElse(null);

    }
}
