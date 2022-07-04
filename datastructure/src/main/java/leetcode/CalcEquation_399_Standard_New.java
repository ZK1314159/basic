package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/18 16:44 <br>
 */
//    1 <= equations.length <= 20
//    equations[i].length == 2
//    1 <= Ai.length, Bi.length <= 5
//    values.length == equations.length
//    0.0 < values[i] <= 20.0
//    1 <= queries.length <= 20
//    queries[i].length == 2
//    1 <= Cj.length, Dj.length <= 5
//    Ai, Bi, Cj, Dj 由小写英文字母与数字组成
public class CalcEquation_399_Standard_New {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();
        Node[] array = new Node[equationSize * 2];
        Map<String, Integer> map = new HashMap<>(equationSize * 2);
        int id = -1;
        for (int i = 0; i < equationSize; i++) {
            List<String> list = equations.get(i);
            String var1 = list.get(0);
            String var2 = list.get(1);
            if (! map.containsKey(var1)) {
                id++;
                map.put(var1, id);
                array[id] = new Node();
            }
            if (! map.containsKey(var2)) {
                id++;
                map.put(var2, id);
                array[id] = new Node();
            }
            union(array[map.get(var1)], array[map.get(var2)], values[i]);
        }

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String var1 = list.get(0);
            String var2 = list.get(1);
            Integer integer1 = map.get(var1);
            Integer integer2 = map.get(var2);
            if (integer1 == null || integer2 == null) {
                answer[i] = -1.0D;
                continue;
            }
            answer[i] = isConnected(array[integer1], array[integer2]);
        }

        return answer;
    }

    public void union(Node first, Node second, double value) {
        Node rootFirst = find(first);
        Node rootSecond = find(second);
        if (rootFirst == rootSecond) {
            return;
        }
        rootFirst.parent = rootSecond;
        rootFirst.weight = second.weight * value / first.weight;
    }

    public Node find(Node node) {
        if (node.parent == null) {
            return node;
        }
        Node node1 = find(node.parent);
        node.weight *= node.parent.weight;
        node.parent = node1;
        return node1;
    }

    public double isConnected(Node first, Node second) {
        Node rootFirst = find(first);
        Node rootSecond = find(second);
        if (rootFirst != rootSecond) {
            return -1.0D;
        }
        return first.weight / second.weight;
    }

    public static class Node {

        private Node parent;

        private double weight = 1.0D;
    }

    public static void main(String[] args) {
        CalcEquation_399_Standard_New test = new CalcEquation_399_Standard_New();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a","b")));
        equations.add(new ArrayList<>(Arrays.asList("e","f")));
        equations.add(new ArrayList<>(Arrays.asList("b","e")));
        double[] values = new double[]{3.4,1.4,2.3};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("b","a")));
        queries.add(new ArrayList<>(Arrays.asList("a","f")));
        queries.add(new ArrayList<>(Arrays.asList("f","f")));
        queries.add(new ArrayList<>(Arrays.asList("e","e")));
        queries.add(new ArrayList<>(Arrays.asList("c","c")));
        queries.add(new ArrayList<>(Arrays.asList("a","c")));
        queries.add(new ArrayList<>(Arrays.asList("f","e")));
        double[] answer = test.calcEquation(equations, values, queries);
    }

}
