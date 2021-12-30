package main.java.algorithm.review;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/8 11:17 <br>
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.removeLast();
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.pop();
        deque.forEach(System.out::println);
    }
}
