package historry.exam2018.pingan;

import java.util.*;

public class Main2 {
    private static class Node {
        List<Node> adj;
        int dist;

        Node(int dist) {
            this.dist = dist;
            adj = new LinkedList<>();
        }
    }

    private void countRoad(Node[] map, int i) {
        Node start = map[i];
        start.dist = 0;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(start);
        while (!que.isEmpty()) {
            Node v = que.remove();
            v.adj.forEach(w -> {
                if (w.dist == Integer.MAX_VALUE) {
                    w.dist = v.dist + 1;
                    que.offer(w);
                }
            });
        }
    }

    private void buildMap(int[] arr, Node[] map, List<Integer> list) {

        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = new Node(Integer.MAX_VALUE);
        }
        for (int i = 0; i < list.size(); i += 2) {
            map[list.get(i)].adj.add(map[list.get(i + 1)]);
        }
    }

    private int findRoot(List<Integer> list) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < list.size(); i += 2) {
            set1.add(list.get(i));
            set2.add(list.get(i + 1));
        }
        for (int i : set1) {
            if (!set2.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    private int countLength(Node[] map) {
        int height = 0;
        for (Node v : map) {
            if (v != null) {
                if (v.dist > height) {
                    height = v.dist;
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int i = in.nextInt();
            if (i == -1) {
                break;
            } else {
                list.add(i);
            }
        }
        Set<Integer> set = new HashSet<>(list);
        int max = Collections.max(set);
        Node[] map = new Node[max + 1];
        List<Integer> tmp = new ArrayList<>(set);
        int[] arr = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            arr[i] = tmp.get(i);
        }
        m.buildMap(arr, map, list);
        int root = m.findRoot(list);
        m.countRoad(map, root);
        int height = m.countLength(map);
        System.out.print(height + 1);
    }
}
