package love.jiahao.figure;

import java.util.LinkedList;
import java.util.List;

/**
 * <big>拓扑排序-DFS</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class TopologicalSortDFS {
    public static void main(String[] args) {
        topologicalSort(Demo.getVertex2());
    }

    private static void topologicalSort(List<Vertex> vertexList) {
        LinkedList<Vertex> stack = new LinkedList<>();
        for (Vertex vertex : vertexList) {
            dfs(vertex, stack);
        }
        System.out.println(stack);
    }

    private static void dfs(Vertex vertex, LinkedList<Vertex> stack) {
        if (vertex.status == 2) {
            return;
        }
        if (vertex.status == 1) {
            throw new RuntimeException("有环");
        }

        vertex.status = 1;

        for (Edge edge : vertex.edges) {
            dfs(edge.linked, stack);
        }
        vertex.status = 2;
        stack.push(vertex);
    }
}
