package main.java.algorithm.review;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/9 15:22 <br>
 */
public class UnWeightedRouteTest {
    private static class Vertex {
        int dist;
        Vertex path;
        LinkedList<Vertex> adj;
        int position;

        public Vertex(int position, int dist, Vertex path, LinkedList<Vertex> adj) {
            this.position = position;
            this.dist = dist;
            this.path = path;
            this.adj = adj;
        }

        @Override
        public String toString() {
            return "Node" + position;
        }
    }

    void build(Vertex[] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Vertex(i, Integer.MAX_VALUE, null, new LinkedList<>());
        }
        map[0].adj.add(map[1]);
        map[0].adj.add(map[3]);
        map[1].adj.add(map[3]);
        map[1].adj.add(map[4]);
        map[2].adj.add(map[5]);
        map[2].adj.add(map[0]);
        map[3].adj.add(map[2]);
        map[3].adj.add(map[4]);
        map[3].adj.add(map[5]);
        map[3].adj.add(map[6]);
        map[4].adj.add(map[6]);
        map[6].adj.add(map[5]);
    }

    void find(Vertex start) {
        start.dist = 0;
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            v.adj.forEach(w -> {
                if (w.dist == Integer.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    queue.offer(w);
                }
            });
        }
    }

    public static void main(String[] args) {
        UnWeightedRouteTest test = new UnWeightedRouteTest();
        Vertex[] map = new Vertex[7];
        test.build(map);
        test.find(map[0]);
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i].toString() + ": " + map[i].dist);
        }
    }
}
