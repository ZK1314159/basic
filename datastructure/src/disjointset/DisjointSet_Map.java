package disjointset;

import java.util.*;

//采用Map处理字符串的不相交集问题，是最普适、快速的算法
//如果有重复元素应该先去重
public class DisjointSet_Map {
    //为了使用Map方便定义了可以在整个对象中使用的变量map
    private Map<String, Node> map;

    private static class Node {
        String father;
        int height;

        Node(String father, int height) {
            this.father = father;
            this.height = height;
        }

        public String toString() {
            return "father[" + father + "]" + " " + "height[" + height + "]";
        }
    }

    private void union(String st1, String st2) {
        String root1 = find(st1);
        String root2 = find(st2);
        if (map.get(root1).height > map.get(root2).height) {
            map.get(root2).father = root1;
        } else {
            if (map.get(root1).height == map.get(root2).height) {
                map.get(root2).height++;
            }
            map.get(root1).father = root2;
        }
    }

    private String find(String st) {
        if (map.get(st).father == null) {
            return st;
        }
        return map.get(st).father = find(map.get(st).father);
    }

    private void buildMap(String[] st, Map<String, Node> map) {
        for (String s : st) {
            map.put(s, new Node(null, 0));
        }
    }

    public static void main(String[] args) {
        String[] st = {"c", "java", "cpp", "python", "php", "spring", "mysql", "oracle", "love", "hate"};
        DisjointSet_Map dsm = new DisjointSet_Map();
        dsm.map = new HashMap<>();
        dsm.buildMap(st, dsm.map);
        dsm.union("java", "python");
        dsm.union("c", "cpp");
        dsm.union("java", "c");
        System.out.println(dsm.find("java"));
        System.out.println(dsm.find("cpp"));
        System.out.println(dsm.find("python"));
        System.out.println(dsm.find("c"));
        dsm.map.forEach((key, value) -> System.out.println("key[" + key + "]" + " " + value));
    }
}
