package graph;

import java.util.*;

public class Dijkstra_Algorithm {
    private static class Vertex {
        Map<Vertex, Integer> adj;
        boolean known;
        int dist;
        Vertex path;

        Vertex(boolean known, int dist, Vertex path) {
            this.known = known;
            this.dist = dist;
            this.path = path;
            adj = new HashMap<>();
        }
    }

    private void find(Vertex[] map, int i, PriorityQueue<Vertex> pri) {
        Vertex start = map[i];
        start.dist = 0;
        pri.offer(start);
        while (!pri.isEmpty()) {
            Vertex v = pri.poll();
            if (!v.known) {
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
    }

    private void build(Vertex[] map) {
        Map<Vertex, Integer> tmp = new HashMap<>();
        tmp.put(map[1], 2);
        tmp.put(map[3], 1);
        map[0].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[3], 3);
        tmp.put(map[4], 10);
        map[1].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[0], 4);
        tmp.put(map[5], 5);
        map[2].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[2], 2);
        tmp.put(map[4], 2);
        tmp.put(map[5], 8);
        tmp.put(map[6], 4);
        map[3].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[6], 6);
        map[4].adj.putAll(tmp);
        tmp.clear();
        tmp.put(map[5], 1);
        map[6].adj.putAll(tmp);
    }

    public static void main(String[] args) {
        Dijkstra_Algorithm dijkstra = new Dijkstra_Algorithm();
        Vertex[] map = new Vertex[7];
        final int max = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            map[i] = new Vertex(false, max, null);
        }
        dijkstra.build(map);
        PriorityQueue<Vertex> pri = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        for (Vertex v : map) {
            pri.offer(v);
        }
        dijkstra.find(map, 0, pri);
        for (int i = 0; i < map.length; i++) {
            System.out.println("map[" + i + "]: " + map[i].dist);
        }
    }
}
