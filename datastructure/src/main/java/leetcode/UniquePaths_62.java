package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/9 9:56 <br>
 */
public class UniquePaths_62 {

    int[][] history;

    public int uniquePaths(int m, int n) {
        history = new int[m][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{m - 1, n - 1});
        while (!deque.isEmpty()) {
            int[] position = deque.poll();
            int y = position[0];
            int x = position[1];
            if (history[y][x] > 0) {
                continue;
            }

            int down = 0;
            if (y < m - 1) {
                down = history[y + 1][x];
            }
            int right = 0;
            if (x < n - 1) {
                right = history[y][x + 1];
            }
            if (down == 0 && right == 0) {
                history[y][x] = 1;
            } else {
                history[y][x] = down + right;
            }

            if (x > 0) {
                deque.offer(new int[]{y, x - 1});
            }
            if (y > 0) {
                deque.offer(new int[]{y - 1, x});
            }
        }

        return history[0][0];
    }

}
