package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public class CalcEquation_399 {

    private Map<String, List<Point>> map;
    private Set<String> set;

    public static class Point {
        private String string;
        private double value;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>(equations.size());
        set = new HashSet<>(equations.size());
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String start = list.get(0);
            String end = list.get(1);
            List<Point> pointList = map.computeIfAbsent(start, v -> new ArrayList<>());
            Point point = new Point();
            point.string = end;
            point.value = values[i];
            pointList.add(point);
            set.add(start);
            List<Point> pointList2 = map.computeIfAbsent(end, v -> new ArrayList<>());
            Point point2 = new Point();
            point2.string = start;
            point2.value = 1 / values[i];
            pointList2.add(point2);
            set.add(end);
        }

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String start = list.get(0);
            String end = list.get(1);
            List<Double> doubles = new ArrayList<>();
            Set<String> path = new HashSet<>();
            Double value = dfs(start, 1, end, doubles, path);
            answer[i] = value == null ? - 1.0 : value;
        }

        return answer;
    }

    Double dfs(String start, double number, String end, List<Double> doubles, Set<String> path) {
        doubles.add(number);
        if (path.contains(start)) {
            return null;
        }
        if (end.equals(start)) {
            if (set.contains(start)) {
                double value = doubles.get(0);
                for (int i = 1; i < doubles.size(); i++) {
                    value *= doubles.get(i);
                }
                return value;
            } else {
                return -1.0;
            }
        }
        path.add(start);
        List<Point> pointList = map.get(start);
        if (pointList == null) {
            return null;
        }
        for (Point point : pointList) {
            Double value = dfs(point.string, point.value, end, doubles, path);
            if (value != null) {
                return value;
            }
            doubles.remove(doubles.size() - 1);
        }

        return null;
    }

    public static List<Integer> getList(boolean useArray, int size) {
        if (useArray) {
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            return list;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;

    }

    public static void main(String[] args) {
        int size = 1000 * 100;
        long start = System.currentTimeMillis();
        List list = getList(true, size);
        for (int i = 0; i < 10000; i++) {
            boolean hasResult = list.contains(size - 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        CalcEquation_399 test = new CalcEquation_399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a","b")));
        equations.add(new ArrayList<>(Arrays.asList("b","c")));
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a","c")));
        queries.add(new ArrayList<>(Arrays.asList("b","a")));
        queries.add(new ArrayList<>(Arrays.asList("a","e")));
        queries.add(new ArrayList<>(Arrays.asList("a","a")));
        queries.add(new ArrayList<>(Arrays.asList("x","x")));
        double[] answer = test.calcEquation(equations, values, queries);
    }

}
