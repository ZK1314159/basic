package graph;

import java.util.*;

/**
 * 之前的算法的确是错的，对于二叉堆的节点值的更改是直接修改节点值，这破坏了二叉堆的堆结构
 */
public class DijkstraAlgorithm {

    private static class Vertex {

        Map<Vertex, Integer> adj;
        boolean known;
        Vertex path;
        int dist;

        Vertex(boolean known, Vertex path, int dist) {
            this.known = known;
            this.path = path;
            this.dist = dist;
            adj = new HashMap<>();
        }

    }

    private static class PriorityVertex {

        Vertex vertex;
        int dist;

        int getDist() {
            return this.dist;
        }

        PriorityVertex(Vertex vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    private void find(Vertex start, PriorityQueue<PriorityVertex> pri) {
        start.dist = 0;
        PriorityVertex priorityVertex = new PriorityVertex(start, start.dist);
        pri.offer(priorityVertex);
        while (!pri.isEmpty()) {
            PriorityVertex pv = pri.poll();
            Vertex v = pv.vertex;
            if (!v.known) {
                v.known = true;
                v.adj.forEach((w, d) -> {
                    if (!w.known) {
                        if (v.dist + d < w.dist) {
                            w.dist = v.dist + d;
                            w.path = v;
                            PriorityVertex newPriorityVertex = new PriorityVertex(w, w.dist);
                            pri.offer(newPriorityVertex);
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
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        Vertex[] map = new Vertex[7];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            map[i] = new Vertex(false, null, max);
        }
        dijkstra.build(map);
        PriorityQueue<PriorityVertex> pri = new PriorityQueue<>(Comparator.comparingInt(PriorityVertex::getDist));
        for (Vertex v : map) {
            PriorityVertex priorityVertex = new PriorityVertex(v, v.dist);
            pri.offer(priorityVertex);
        }
        int startPoint = 1;
        Vertex start = map[startPoint];
        dijkstra.find(start, pri);
        for (int i = 0; i < map.length; i++) {
            System.out.println("map[" + i + "]: " + map[i].dist);
        }
    }
}
