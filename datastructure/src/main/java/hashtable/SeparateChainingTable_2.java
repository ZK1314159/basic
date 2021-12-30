package main.java.hashtable;

import java.util.*;

class SeparateChainingTable_2<T> {
    static final int intCapacity = 10;
    List<T>[] lists;

    public SeparateChainingTable_2() {
        this(intCapacity);
    }

    //@SuppressWarnings("unchecked")
    public SeparateChainingTable_2(int capacity) {
        lists = new LinkedList[intCapacity];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    int hash(T t) {
        int i = (Integer) t;
        return i % lists.length;
    }

    boolean contains(T t) {
        List<T> list = lists[hash(t)];
        return list.contains(t);
    }

    boolean add(T t) {
        List<T> list = lists[hash(t)];
        if (list.contains(t)) {
            return false;
        }
        list.add(t);
        return true;
    }

    boolean remove(T t) {
        List<T> list = lists[hash(t)];
        if (list.contains(t)) {
            list.remove(t);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SeparateChainingTable_2<Integer> s = new SeparateChainingTable_2<>();
        s.add(4371);
        s.add(1323);
        s.add(6173);
        s.add(4199);
        s.add(4344);
        s.add(9679);
        s.add(1989);
        for (List<Integer> list : s.lists) {
            if (!list.isEmpty()) {
                System.out.println(list);
            } else {
                System.out.println("null");
            }
        }
    }
}
