package main.java.algorithm.review;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/9 11:07 <br>
 */
public class DijkstraAlgorithmTest {
    private static class Vertex {
        int dist;
        boolean known;
        Vertex path;
        Map<Vertex, Integer> adj;
        int position;

        public Vertex(int position, int dist, boolean known, Vertex path, HashMap<Vertex, Integer> adj) {
            this.position = position;
            this.dist = dist;
            this.known = known;
            this.path = path;
            this.adj = adj;
        }

        @Override
        public String toString() {
            return "Node" + position;
        }
    }

    void build(Vertex[] map) {
        Map<Vertex, Integer> tmp = new HashMap<>();
        tmp.put(map[1], 2);
        tmp.put(map[3], 1);
        map[0].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[4], 10);
        tmp.put(map[3], 3);
        map[1].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[0], 4);
        tmp.put(map[5], 5);
        map[2].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[2], 2);
        tmp.put(map[5], 8);
        tmp.put(map[6], 4);
        tmp.put(map[4], 2);
        map[3].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[6], 6);
        map[4].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[5], 1);
        map[6].adj.putAll(tmp);
    }

    void find(Vertex start, Vertex[] map) {
        Queue<Vertex> pri = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        for (int i = 0; i < map.length; i++) {
            pri.offer(map[i]);
        }
        start.dist = 0;
        pri.offer(start);
        while (!pri.isEmpty()) {
            Vertex v = pri.poll();
            v.known = true;
            v.adj.forEach((w, d) -> {
                if (!w.known) {
                    if (v.dist + d < w.dist) {
                        w.dist = v.dist + d;
                        w.path = v;
                        pri.offer(w);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithmTest dijkstra = new DijkstraAlgorithmTest();
        Vertex[] map = new Vertex[7];
        for (int i = 0; i < map.length; i++) {
            map[i] = new Vertex(i, Integer.MAX_VALUE, false, null, new HashMap<>());
        }
        dijkstra.build(map);
        dijkstra.find(map[0], map);
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i].toString() + ": " + map[i].dist);
        }
        Vertex path = map[6].path;
        while (path != null) {
            System.out.println(path);
            path = path.path;
        }
    }
}
