package love.jiahao.figure;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <big>弗洛伊德算法-多源最短路径求解-加强版</big>
 * <p>可以解决负数问题，但是不能解决负环</p>
 * <p>添加可以得知是从哪过来的</p>
 *
 * @author 13684
 * @date 2024/5/13
 */
public class FloydWarshallPlus {
    public static void main(String[] args) {
        List<Vertex> vertexList = Demo.getVertex4();
        floyd(vertexList);
    }

    public static void floyd(List<Vertex> vertexList) {
        int size = vertexList.size();
        int[][] result = new int[size][size];
        Vertex[][] prev = new Vertex[size][size];
        // 初始化
        // 初始化一个二维数组，长度为节点个数，矩阵中每个元素代表两个节点之间的距离
        // 如果两点不相连暂时定为无穷大
        for (int i = 0; i < size; i++) {
            Vertex iNode = vertexList.get(i);
            Map<Vertex, Integer> iMap = iNode.edges.stream().collect(Collectors.toMap(n -> n.linked, n -> n.weight));
            for (int j = 0; j < size; j++) {
                Vertex jNode = vertexList.get(j);
                if (iNode == jNode) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = iMap.getOrDefault(jNode, Integer.MAX_VALUE);
                    prev[i][j] = iMap.get(jNode) == null ? null : iNode;
                }
            }
        }
        printArray(result);
        printArray2(prev);

        // 进行处理，看借助其他顶点能否到达目标节点
        // 遍历矩阵，分别使用其他顶点，看是否能够借助其他顶点到达目标节点
        // 同时距离取最小值
        // 最外层循环，代表这一轮借助的顶点
        for (int i = 0; i < size; i++) {
            // 当前访问的哪一行
            for (int j = 0; j < size; j++) {
                // 当前访问的哪一列
                for (int k = 0; k < size; k++) {
                    // 当前节点到借助顶点和借助顶点到目标顶点为无穷大时不需要任何处理
                    if (result[j][i] == Integer.MAX_VALUE || result[i][k] == Integer.MAX_VALUE) {
                        continue;
                    } else if (result[j][k] > result[j][i] + result[i][k]){
                        // 如果借助其他节点会到自身距离更短，说明出现了负环
                        if (j == k) {
                            throw new RuntimeException("出现负环");
                        }
                        result[j][k] = result[j][i] + result[i][k];
                        // 更新上一节点
                        prev[j][k] = prev[i][k];
                    }
                }
            }
            printArray(result);
        }
        // 最后得到的二维数组就是顶点到其他顶点的最短路径
        printArray(result);
        printArray2(prev);
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] == Integer.MAX_VALUE ? "∞\t" : arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    public static void printArray2(Vertex[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print((arr[i][j] == null? "00": arr[i][j].getName()) + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
