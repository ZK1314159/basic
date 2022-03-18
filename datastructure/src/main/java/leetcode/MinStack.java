package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/18 16:43 <br>
 */
class MinStack {

    LinkedList<Integer> linkedList= new LinkedList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public MinStack() {
    }

    public void push(int val) {
        linkedList.push(val);
        priorityQueue.offer(val);
    }

    public void pop() {
        int val = linkedList.pop();
        priorityQueue.remove(val);
    }

    public int top() {
        return linkedList.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }

}
