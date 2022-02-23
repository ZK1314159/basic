package graph;

import java.util.*;

/**
 * 之前的算法的确是错的，对于二叉堆的节点值的更改是直接修改节点值，这破坏了二叉堆的堆结构
 * 新的方法是将用于二叉堆节点的dist和图节点的dist分开，并且二叉堆节点包含一个图节点
 */
public class DijkstraAlgorithm {

    private static class Vertex {
        Map<Vertex, Integer> adj = new HashMap<>();
        boolean known;
        Vertex path;
        int dist = Integer.MAX_VALUE;
        int id;
        Vertex(int id) {
            this.id = id;
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
            if (! v.known) {
                v.known = true;
                v.adj.forEach((w, d) -> {
                    if (! w.known && v.dist + d < w.dist) {
                        w.dist = v.dist + d;
                        w.path = v;
                        PriorityVertex newPriorityVertex = new PriorityVertex(w, w.dist);
                        pri.offer(newPriorityVertex);
                    }
                });
            }
        }
    }

    private void build(Vertex[] map, PriorityQueue<PriorityVertex> pri) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Vertex(i + 1);
            pri.offer(new PriorityVertex(map[i], map[i].dist));
        }
        map[0].adj.put(map[1], 2);
        map[0].adj.put(map[3], 1);
        map[1].adj.put(map[3], 3);
        map[1].adj.put(map[4], 10);
        map[2].adj.put(map[0], 4);
        map[2].adj.put(map[5], 5);
        map[3].adj.put(map[2], 2);
        map[3].adj.put(map[4], 2);
        map[3].adj.put(map[5], 8);
        map[3].adj.put(map[6], 4);
        map[4].adj.put(map[6], 6);
        map[6].adj.put(map[5], 1);
    }

    void print(Vertex[] map, Vertex end) {
        for (int i = 0; i < map.length; i++) {
            System.out.println("map[" + i + "]: " + map[i].dist);
        }
        System.out.print(end.id + " ");
        while (end.path != null) {
            System.out.print(end.path.id + " ");
            end = end.path;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        Vertex[] map = new Vertex[7];
        PriorityQueue<PriorityVertex> pri = new PriorityQueue<>(Comparator.comparingInt(PriorityVertex::getDist));
        dijkstra.build(map, pri);
        dijkstra.find(map[0], pri);
        dijkstra.print(map, map[5]);
    }

}
