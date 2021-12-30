package graph;

import java.util.*;

public class UnweightedRoute {
    private static class Node {
        List<Node> adj;
        int dist;
        Node path;

        Node(int dist) {
            this.dist = dist;
            adj = new LinkedList<>();
        }
    }

    private void findMin(Node[] map, int i) {
        Node start = map[i];
        start.dist = 0;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(start);
        while (!que.isEmpty()) {
            Node v = que.poll();
            v.adj.forEach(w -> {
                if (w.dist == Integer.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    que.offer(w);
                }
            });
        }
    }

    private void build(Node[] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Node(Integer.MAX_VALUE);
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

    public static void main(String[] args) {
        UnweightedRoute route = new UnweightedRoute();
        Node[] map = new Node[7];
        route.build(map);
        route.findMin(map, 2);
        for (int i = 0; i < map.length; i++) {
            System.out.println("Node[" + i + "]: " + map[i].dist);
        }
    }
}
