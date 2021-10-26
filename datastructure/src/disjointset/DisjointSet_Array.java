package disjointset;

import java.util.*;

//用数组和Map处理字符串的不相交集问题，不是很简洁，适用性比较差
public class DisjointSet_Array {
    private Map<String, Integer> map;
    private Node[] arr;

    private static class Node {
        int height;
        String father;

        Node(int height, String father) {
            this.height = height;
            this.father = father;
        }

        public String toString() {
            return "father[" + father + "]" + " " + "height[" + height + "]";
        }
    }

    private DisjointSet_Array(int in) {
        arr = new Node[in];
        for (int i = 0; i < in; i++) {
            arr[i] = new Node(1, null);
        }
    }

    private String find(String st) {
        if (arr[map.get(st)].father == null) {
            return st;
        }
        return arr[map.get(st)].father = find(arr[map.get(st)].father);
    }

    private void union(String st1, String st2) {
        String root1 = find(st1);
        String root2 = find(st2);
        if (arr[map.get(root1)].height > arr[map.get(root2)].height) {
            arr[map.get(root2)].father = root1;
        } else {
            if (arr[map.get(root1)].height == arr[map.get(root2)].height) {
                arr[map.get(root2)].height++;
            }
            arr[map.get(root1)].father = root2;
        }
    }

    public static void main(String[] args) {
        String[] st = {"c", "java", "cpp", "python", "php", "spring", "mysql", "oracle", "love", "hate"};
        DisjointSet_Array dss = new DisjointSet_Array(st.length);
        dss.map = new HashMap<>();
        for (int i = 0; i < st.length; i++) {
            dss.map.put(st[i], i);
        }
        dss.union("java", "python");
        dss.union("c", "cpp");
        dss.union("java", "c");
        System.out.println(dss.find("java"));
        System.out.println(dss.find("cpp"));
        System.out.println(dss.find("python"));
        System.out.println(dss.find("c"));
        for (int i = 0; i < st.length; i++) {
            System.out.println("[" + i + " : " + dss.arr[i] + "]");
        }
    }
}
