package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description：<br>
 * 16:33开始看题
 * 16:42 想到算法
 * 17:14 写完算法
 * 17:14 算法AC
 * 17:34 官方算法AC
 * CreateDate：2022/3/18 16:43 <br>
 */
class MinStack_155_standard {

    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> backup = new LinkedList<>();

    public MinStack_155_standard() {
        backup.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        backup.push(Math.min(backup.peek(), val));
    }

    public void pop() {
        stack.pop();
        backup.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return backup.peek();
    }

}
