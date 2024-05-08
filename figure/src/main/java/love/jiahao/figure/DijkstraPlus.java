package love.jiahao.figure;

import java.util.*;

/**
 * <big>迪克斯特拉 单源最短路径算法-改进版</big>
 *
 * @author 13684
 * @date 2024/5/7
 */
public class DijkstraPlus {
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
        // 1.将所有顶点存入 优先级队列(底层为小顶堆) 中去
        PriorityQueue<Vertex> unVisited = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
        // 2.将起点的距离设置为0
        vertex.setDistance(0);
        for (Vertex vertex1 : vertexList) {
            unVisited.offer(vertex1);
        }

        while (!unVisited.isEmpty()) {
            // 3. 选取当前顶点 (距离最小的当顶点) 正是当前队列顶点
            Vertex temp = unVisited.peek();
            // 4. 更新当前顶点邻居距离
            updateNeighborDist(temp, unVisited);
            // 5. 移除当前顶点
            unVisited.poll();
            // 5. 将当前节点标记为访问过
            temp.visited = true;
        }

        for (Vertex vertex1 : vertexList) {
            System.out.println(vertex1.name + "-->" + vertex1.distance + "-->" + vertex1.prev);
        }
    }

    private static void updateNeighborDist(Vertex temp, PriorityQueue<Vertex> unVisited) {
        // 遍历每一个邻居，如果距离加上权重小于当前的距离就更新距离值
        for (Edge edge : temp.edges) {
            Vertex n = edge.linked;
            int dist = temp.distance + edge.weight;
            if (!n.visited &&  dist < n.distance) {
                n.prev = temp;
                n.setDistance(dist);
                // 需要重新加入队列一次，因为距离变化，队列不会改变顺序
                // 同时先删后加，防止重复，虽然重复也没事
                unVisited.remove(n);
                unVisited.offer(n);
            }
        }
    }
}
