package main.java.collection;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMap_Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(7);
        set.add(8);
        set.add(4);
        set.add(6);
        set.add(9);
        set.add(4);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(4, 7);
        map.put(4, 7);
        map.forEach((key, value) -> System.out.print(key + " " + value));
    }
}
