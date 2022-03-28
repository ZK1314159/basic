package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/28 16:36 <br>
 */
public class ValidateStackSequences_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();
        int position = 0;
        for (int num : pushed) {
            deque.push(num);
            while (!deque.isEmpty() && position < pushed.length && deque.peek() == popped[position]) {
                position++;
                deque.poll();
            }
        }
        return position == pushed.length;
    }

}
