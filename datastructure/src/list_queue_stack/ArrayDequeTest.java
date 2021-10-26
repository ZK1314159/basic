package list_queue_stack;

import java.util.*;

class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        deque.offer(5);
        deque.offer(6);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.forEach(System.out::print);
    }

}
