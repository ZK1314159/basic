package leetcode;

/**
 * Description：<br>
 * 9:47 开始读题
 * 9:55 想到算法
 * 10:19 写完算法
 * 10:21 算法AC
 * 10:45 官方算法AC
 * CreateDate：2022/3/9 9:56 <br>
 */
public class UniquePaths_62_standard {

    public int uniquePaths(int m, int n) {
        int[][] history = new int[m][n];
        for (int i = 0; i < m; i++) {
            history[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            history[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                history[i][j] = history[i][j - 1] + history[i - 1][j];
            }
        }

        return history[m - 1][n - 1];
    }

}
