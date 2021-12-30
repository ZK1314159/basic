package main.java.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：无权最短路，包含路径的计算
 * <br>
 * CreateDate：2021/10/27 16:58 <br>
 */
public class UnWeightedRouteNew {

    public static class Vertex {
        List<Vertex> adj;
        int dist;
        Vertex path;
        int id;

        Vertex(int dist, int id) {
            this.dist = dist;
            this.id = id;
            this.adj = new LinkedList<>();
        }
    }

    private void count(Vertex start) {
        start.dist = 0;
        Deque<Vertex> deque = new ArrayDeque<>();
        deque.offer(start);
        while (! deque.isEmpty()) {
            Vertex v = deque.poll();
            v.adj.forEach( (w) -> {
                if (w.dist == Integer.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    deque.offer(w);
                }
            });
        }
    }

    private void buildMap(Vertex[] vertexArray) {
        int intMax = Integer.MAX_VALUE;
        for (int i = 0; i <= vertexArray.length - 1; i++) {
            vertexArray[i] = new Vertex(intMax, i + 1);
        }
        vertexArray[0].adj.add(vertexArray[1]);
        vertexArray[0].adj.add(vertexArray[3]);
        vertexArray[1].adj.add(vertexArray[3]);
        vertexArray[1].adj.add(vertexArray[4]);
        vertexArray[2].adj.add(vertexArray[0]);
        vertexArray[2].adj.add(vertexArray[5]);
        vertexArray[3].adj.add(vertexArray[2]);
        vertexArray[3].adj.add(vertexArray[4]);
        vertexArray[3].adj.add(vertexArray[5]);
        vertexArray[3].adj.add(vertexArray[6]);
        vertexArray[4].adj.add(vertexArray[6]);
        vertexArray[6].adj.add(vertexArray[5]);
    }

    public static void main(String[] args) {
        Vertex[] vertexArray = new Vertex[7];
        UnWeightedRouteNew unWeightedRouteNew = new UnWeightedRouteNew();
        unWeightedRouteNew.buildMap(vertexArray);
        int startPoint = 0;
        Vertex start = vertexArray[startPoint];
        unWeightedRouteNew.count(start);
        for (Vertex vertex : vertexArray) {
            System.out.println("节点：" + vertex.id + ", 最短路程：" + vertex.dist);
        }
        int endPoint = 5;
        Vertex end = vertexArray[endPoint];
        while (end != null) {
            System.out.print(end.id);
            end = end.path;
        }
    }
}
