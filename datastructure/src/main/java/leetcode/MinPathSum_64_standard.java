package leetcode;

/**
 * Description：<br>
 * 10:57 开始看题
 * 11:00 想到算法
 * 11:30 写完算法
 * 11:37 算法AC
 * 11:54 官方算法AC
 * CreateDate：2022/3/9 11:01 <br>
 */
public class MinPathSum_64_standard {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] history = new int[rows][columns];
        history[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            history[i][0] = history[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < columns; i++) {
            history[0][i] = history[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int min = Math.min(history[i][j - 1], history[i - 1][j]);
                history[i][j] = min + grid[i][j];
            }
        }

        return history[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        MinPathSum_64_standard test = new MinPathSum_64_standard();
        int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int answer = test.minPathSum(grid);
    }

}
