package main.java.algorithm.review;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description：堆的java实现类 <br>
 * <br>
 * CreateDate：2020/6/8 20:25 <br>
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(-4);
        queue.add(79);
        queue.add(34);
        queue.add(17);
        queue.poll();
        queue.add(-78);
        queue.forEach(System.out::println);
    }
}
