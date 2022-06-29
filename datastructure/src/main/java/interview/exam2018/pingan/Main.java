package interview.historry.exam2018.pingan;

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

    private void countRoad(Map<Integer, Node> map, int i) {
        Node start = map.get(i);
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

    private void buildMap(int[] arr, Map<Integer, Node> map, List<Integer> list) {

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], new Node(Integer.MAX_VALUE));
        }
        for (int i = 0; i < list.size(); i += 2) {
            map.get(i).adj.add(map.get(i + 1));
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

    private int countLength(Map<Integer, Node> map) {
        int height = 0;
        for (int i : map.keySet()) {
            if (map.get(i).dist > height) {
                height = map.get(i).dist;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Main m = new Main();
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
        Map<Integer, Node> map = new HashMap<>();
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
