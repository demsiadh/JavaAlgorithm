package love.jiahao.figure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <big>拓扑排序</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class TopologicalSort {
    public static void main(String[] args) {
        List<Vertex> vertex2 = Demo.getVertex2();
        //for (Vertex vertex : vertex2) {
        //    System.out.println(vertex.name + "->入度: " + vertex.inDegree);
        //}
        topologicalSort2(vertex2);
    }

    // 拓扑排序
    private static List<Vertex> topologicalSort(List<Vertex> vertexList) {
        LinkedList<Vertex> queue = new LinkedList<>();
        List<Vertex> result = new ArrayList<>();
        // 1.将入度为0的顶点加入到集合中
        for (Vertex vertex : vertexList) {
            if (vertex.inDegree == 0) {
                queue.add(vertex);
            }
        }

        // 2.从队列中移除顶点，并修改相邻顶点的入度，将0入度的入队
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            result.add(poll);
            for (Edge edge : poll.edges) {
                edge.linked.inDegree--;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked);
                }
            }
        }

        System.out.println(result);
        return result;
    }

    // 拓扑排序（检测是否有环）
    private static void topologicalSort2(List<Vertex> vertexList) {
        List<Vertex> vertices = topologicalSort(vertexList);
        if (vertices.size() != vertexList.size()) {
            System.out.println("有环");
        } else {
            System.out.println("无环");
        }
    }
}
