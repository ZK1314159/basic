package leetcode;

/**
 * Description：<br>
 * 16:20 开始看题
 * 17:00 看官方解答并优化到最佳
 * CreateDate：2022/6/4 16:51 <br>
 */

// 1 <= n <= 104
public class MumSquares_279 {

    public int numSquares(int n) {
        int[] history = new int[n + 1];
        history[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, history[i - j * j]);
            }
            history[i] = min + 1;
        }
        return history[n];
    }

}
