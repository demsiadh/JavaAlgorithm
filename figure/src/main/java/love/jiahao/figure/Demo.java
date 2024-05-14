package love.jiahao.figure;

import java.util.ArrayList;
import java.util.List;

/**
 * <big>简单表示图</big>
 *
 * @author 13684
 * @date 2024/4/16
 */
public class Demo {
    public static void main(String[] args) {
        /*
             |-->b--->|
            a         d
             |-->c--->|
         */
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }

    // 获取图
    /*
         /--(14)-->6-------(9)-------\
        1--(7)-->2--(15)-->\          5
         \--(9)-->3--(11)-->4--(6)-->/
         附 3 --(2)-->6
     */
    public static List<Vertex> getVertex1() {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");
        v1.edges = List.of(
                new Edge(v6, 14),
                new Edge(v2, 7),
                new Edge(v3, 9));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(
                new Edge(v4, 11),
                new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9), new Edge(v1, 9));
        return new ArrayList<>(List.of(v1, v2, v3, v4, v5, v6));
    }

    /*
                      数据库  ---->\
        网页基础 ---->\             Spring框架 ----> 微服务 ----> 实战项目
                      JavaWeb---->/
        Java基础---->/
     */
    public static List<Vertex> getVertex2() {
        Vertex v1 = new Vertex("Java基础");
        Vertex v2 = new Vertex("网页基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("数据库");
        Vertex v5 = new Vertex("Spring框架");
        Vertex v6 = new Vertex("微服务");
        Vertex v7 = new Vertex("实战项目");
        v1.edges = List.of(new Edge(v3));
        v2.edges = List.of(new Edge(v3));
        v3.edges = List.of(new Edge(v5));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of(new Edge(v6));
        v6.edges = List.of(new Edge(v7));
        v7.edges = List.of();
        //v7.edges = List.of(new Edge(v6));

        return new ArrayList<>(List.of(v1, v2, v3, v4, v5, v6, v7));
    }


    /*
        v1--(2)-->v2--(1)-->v3--(1)-->v4
          \------(-2)------/
     */
    public static List<Vertex> getVertex3() {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 1));
        v2.edges = List.of(new Edge(v3, -2));
        v3.edges = List.of(new Edge(v4, 1));
        v4.edges = List.of();

        return new ArrayList<>(List.of(v1, v2, v3, v4));
    }

    /*
        v1--(2)-->v2--(-4)-->v3--(1)-->v1
          \---<--(1)------/
          这里 v1 v2 v3就形成了一个负环，因为三者权重加起来是负数，而且是环状
     */
    public static List<Vertex> getVertex4() {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v2, 2));
        v2.edges = List.of(new Edge(v3, -4));
        v3.edges = List.of(new Edge(v1, 1));
        v4.edges = List.of();
        return new ArrayList<>(List.of(v1, v2, v3, v4));
    }

    /*
            ---(4)->v1--(-2)-->
           /                   \
          v2-------(3)-------->v3
           \                   /
            <-(-1)-v4----(2)--<-
     */
    public static List<Vertex> getVertex5() {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v3, -2));
        v2.edges = List.of(new Edge(v3, 3), new Edge(v1, 4));
        v3.edges = List.of(new Edge(v4, 2));
        v4.edges = List.of(new Edge(v2, -1));
        return new ArrayList<>(List.of(v1, v2, v3, v4));
    }


}
