package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/9 11:01 <br>
 */
public class MinPathSum_64 {

    public static class Node {
        boolean known;
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adj = new HashMap<>();
    }

    public static class PriorityNode {
        Node node;
        int distance;
        PriorityNode(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    Node[][] buildMap(int[][] grid) {
        Node[][] nodes = new Node[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nodes[i][j] = new Node();
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i < grid.length - 1) {
                    nodes[i][j].adj.put(nodes[i + 1][j], grid[i + 1][j]);
                }
                if (j < grid[0].length - 1) {
                    nodes[i][j].adj.put(nodes[i][j + 1], grid[i][j + 1]);
                }
            }
        }
        return nodes;
    }

    public int minPathSum(int[][] grid) {
        Node[][] nodes = buildMap(grid);
        PriorityQueue<PriorityNode> priorityNodes
                = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        nodes[0][0].distance = grid[0][0];
        priorityNodes.offer(new PriorityNode(nodes[0][0], nodes[0][0].distance));
        while (!priorityNodes.isEmpty()) {
            PriorityNode priorityNode = priorityNodes.poll();
            Node node = priorityNode.node;
            int distance = node.distance;
            if (node.known) {
                continue;
            }
            node.known = true;
            for (Map.Entry<Node, Integer> entry : node.adj.entrySet()) {
                Node node1 = entry.getKey();
                int adjDistance = entry.getValue();
                if (node1.known) {
                    continue;
                }
                if (node1.distance > adjDistance + distance) {
                    node1.distance = adjDistance + distance;
                    priorityNodes.offer(new PriorityNode(node1, node1.distance));
                }
            }
        }

        return nodes[nodes.length - 1][nodes[0].length - 1].distance;
    }

    public static void main(String[] args) {
        MinPathSum_64 test = new MinPathSum_64();
        int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int answer = test.minPathSum(grid);
    }

}
