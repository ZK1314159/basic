package main.java.historry.exam2019.qunaer;

import java.util.*;

public class Main {
    private static class Node {
        List<Node> adj;
        int dist;
        Node path;
        int pos;

        Node(int dist, int pos) {
            this.dist = dist;
            adj = new LinkedList<>();
            this.pos = pos;
        }
    }

    private void build(int[] arr, Node[] map) {
        int n = arr.length;
        for (int i = 0; i < map.length; i++) {
            map[i] = new Node(Integer.MAX_VALUE, i);
        }
        for (int i = 0; i < arr.length; i++) {
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
        start.path = null;
        start.dist = 0;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(start);
        while (!que.isEmpty()) {
            Node v = que.remove();
            v.adj.forEach(w -> {
                if (w.dist == Integer.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    que.offer(w);
                    w.path = v;
                }
            });
        }
    }

    private int[] countPath(Node aim) {
        List<Integer> list = new ArrayList<>();
        Node tmp = aim;
        while (tmp.path != null) {
            int dist = tmp.pos - tmp.path.pos;
            list.add(dist);
            tmp = tmp.path;
        }
        Collections.reverse(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        //抽象成无权最短路问题，每个元素用来构造邻接矩阵
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        Node[] map = new Node[list.size()];
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        //构造无权图
        m.build(arr, map);
        //层序遍历
        m.findMin(map, 0);
        int[] step = m.countPath(map[map.length - 1]);
        for (int i = 0; i < step.length - 1; i++) {
            System.out.print(step[i] + " ");
        }
        System.out.print(step[step.length - 1]);
    }
}