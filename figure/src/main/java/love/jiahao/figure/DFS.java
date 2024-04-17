package love.jiahao.figure;

import java.util.LinkedList;
import java.util.List;

/**
 * <big>深度优先遍历</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class DFS {
    public static void main(String[] args) {
        dfs2(Demo.getVertex1().get(0));
    }

    // 非递归实现
    private static void dfs2(Vertex vertex){
        LinkedList<Vertex> stack = new LinkedList<>();
        List<Vertex> result = new LinkedList<>();

        vertex.visited = true;
        stack.push(vertex);
        while (!stack.isEmpty()) {
            Vertex pop = stack.pop();
            result.add(pop);
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    stack.push(edge.linked);
                }
            }
        }

        System.out.println(result);
    }

    // 递归实现深度优先
    private static void dfs(Vertex vertex){
        vertex.visited = true;
        System.out.println(vertex.name);
        for (Edge edge : vertex.edges) {
            if (!edge.linked.visited){
                dfs(edge.linked);
            }
        }
    }

}
