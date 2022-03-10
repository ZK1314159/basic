package leetcode;

import java.util.PriorityQueue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/10 20:39 <br>
 */
public class FindKLargeNumberInIterator_Final {

    public int findKLarge(int n) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        int max = 1;
        int count = 1;
        while (!priorityQueue.isEmpty()) {
            max = priorityQueue.poll();
            count++;
            if (count == n) {
                return max;
            }
            priorityQueue.offer(max * 2 + 1);
            priorityQueue.offer(max * 3 + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        FindKLargeNumberInIterator_Final test = new FindKLargeNumberInIterator_Final();
        int result = test.findKLarge(10000);
    }

}
