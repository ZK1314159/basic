package main.java.hashtable;

import java.util.*;

class SeparateChainingTable_1<T> {
    static final int intCapacity = 5;
    List<T>[] lists;
    int currentSize;

    public SeparateChainingTable_1() {
        this(intCapacity);
    }

    //@SuppressWarnings("unchecked")
    public SeparateChainingTable_1(int capacity) {
        lists = new LinkedList[toPrime(capacity)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    int hash(T t) {
        int i = (Integer) t;
        return i % lists.length;
    }

    int toPrime(int size) {
        if (size % 2 == 0) {
            size++;
        }
        for (; !isPrime(size); size += 2) ;
        return size;
    }

    boolean isPrime(int n) {
        if (n == 1 || n == 3) {
            return true;
        } else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    void rehash() {
        List<T>[] old = lists;
        lists = new LinkedList[toPrime(currentSize)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
        currentSize = 0;
        for (int j = 0; j < old.length; j++) {
            for (T t : old[j]) {
                add(t);
            }
        }
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
        currentSize++;
        if (currentSize > lists.length) {
            rehash();
        }
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
        SeparateChainingTable_1<Integer> s = new SeparateChainingTable_1<>();
        s.add(4371);
        s.add(1323);
        s.add(6173);
        s.add(4199);
        s.add(4344);
        s.add(9679);
        s.add(1989);
        for (List<Integer> list : s.lists) {
            if (!list.isEmpty()) {
                System.out.print(list);
            } else {
                System.out.print("null");
            }
        }
    }
}
