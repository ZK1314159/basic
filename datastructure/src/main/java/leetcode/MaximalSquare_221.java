package leetcode;

/**
 * Description：<br>
 * 15:39开始看题
 * 15:43 想到解法
 * 15:57 解法复杂度太高，预判不是最优解，看官方解答然后看懂
 * 16:11 写完解答并AC
 * CreateDate：2022/6/3 15:57 <br>
 */

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'

public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] history = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        history[i][j] = 1;
                    } else {
                        history[i][j] = Math.min(history[i][j - 1],
                                Math.min(history[i - 1][j], history[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, history[i][j]);
                } else {
                    history[i][j] = 0;
                }
            }
        }
        return max * max;
    }

}
