package love.jiahao.figure;

import java.util.LinkedList;

/**
 * <big>广度优先遍历</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class BFS {
    public static void main(String[] args) {
        Vertex vertex = Demo.getVertex1().get(0);
        bfs(vertex);
    }

    private static void bfs(Vertex vertex) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);
        vertex.visited = true;
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    queue.offer(edge.linked);
                    edge.linked.visited = true;
                }
            }
        }
    }
}
