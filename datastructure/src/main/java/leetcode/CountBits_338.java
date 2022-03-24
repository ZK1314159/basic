package leetcode;

/**
 * Description：<br>
 * 15:27开始看题
 * 15:32 想到算法
 * 17:31 看懂官方解答
 * 17:39 写完官方解答
 * 17:45 官方解答AC
 * CreateDate：2022/3/24 15:34 <br>
 */
public class CountBits_338 {

    public int[] countBits(int n) {
        int[] history = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            history[i] = history[i - high] + 1;
        }
        return history;
    }

}
