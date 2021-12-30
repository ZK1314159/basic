package main.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class PriorityQueue_Test {
    public static void main(String[] args) {

        int[] ins = {1, 4, 5, 6, 7, 23, 34, 33, 33, 43};
        Arrays.sort(ins);
        String[] st = {"a", "cds", "ed", "te", "eds", "abc"};
        Arrays.sort(st);
        for (String i : st) {
            System.out.print(i + " ");
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ins) {
            list.add(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        for (int i = 0; i < ins.length; i++) {
            ins[i] = pq.remove();
        }
    }
}
