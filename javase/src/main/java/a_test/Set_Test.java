package a_test;

import java.util.*;

public class Set_Test {
    int id;
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(1);
        set.forEach(o -> System.out.print(o + " "));
        int size = set.size();
        System.out.println(size);
        boolean bo = set.isEmpty();
        System.out.println(bo);
        boolean co = set.contains(2);
        System.out.println(co);
        //System.out.println();
        set.clear();
        int size_final = set.size();
        System.out.println(size_final);
    }
}
