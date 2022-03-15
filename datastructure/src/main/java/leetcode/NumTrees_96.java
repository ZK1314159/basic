package leetcode;

/**
 * Description：<br>
 * 17:30 开始看题
 * 17:48 想到算法
 * 18:02 写完算法
 * 18:02 算法AC
 * 18:05 官方算法AC
 * CreateDate：2022/3/15 17:50 <br>
 */
public class NumTrees_96 {

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }

        int[] history = new int[n + 1];
        history[0] = 1;
        history[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += history[j - 1] * history[i - j];
            }
            history[i] = sum;
        }
        return history[n];
    }

}
