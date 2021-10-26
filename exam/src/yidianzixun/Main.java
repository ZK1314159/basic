package yidianzixun;

import java.util.*;

public class Main {
    private static class Node {
        List<Node> adj;
        int dist;

        Node(int dist) {
            this.dist = dist;
            adj = new LinkedList<>();
        }
    }

    private void build(int[] arr, Node[] map, int n) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Node(Integer.MAX_VALUE);
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                if (i + j + 1 > n - 1) {
                    break;
                } else {
                    map[i].adj.add(map[i + j + 1]);
                }
            }
        }
    }

    private void findMin(Node[] map, int i) {
        Node start = map[i];
        start.dist = 0;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(start);
        findMin(que);
    }

    private void findMin(Deque<Node> que) {
        Node v = que.remove();
        v.adj.forEach(w -> {
            if (w.dist == Integer.MAX_VALUE) {
                w.dist = v.dist + 1;
                que.offer(w);
            }
        });
        if (!que.isEmpty()) {
            findMin(que);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Node[] map = new Node[num];
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        //构造无权图
        m.build(arr, map, num);
        //层序遍历
        m.findMin(map, 3);
        //获取最小步骤数
        int minStep = map[num - 1].dist;
        System.out.println(minStep);
    }
}