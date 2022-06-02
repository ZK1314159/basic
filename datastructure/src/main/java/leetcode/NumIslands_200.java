package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/2 16:08 <br>
 */
public class NumIslands_200 {

    private int[][] history;
    private char[][] grid;
    private int row;
    private int column;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;
        row = grid.length;
        column = grid[0].length;
        history = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char tmp = grid[i][j];
                if (tmp == '1') {
                    // 判断是否周围存在岛屿
                    // 顺时针核对
                    if (i > 0 && history[i - 1][j] > 0
                        || j < column - 1 && history[i][j + 1] > 0
                        || i < row - 1 && history[i + 1][j] > 0
                        || j > 0 && history[i][j - 1] > 0) {
                        continue;
                    }
                    // 广度优先搜索岛屿
                    count++;
                    search(count, i, j);
                }
            }
        }
        return count;
    }

    void search(int count, int i, int j) {
        if (history[i][j] > 0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        } else {
            history[i][j] = count;
        }

        if (i > 0) {
            search(count, i - 1, j);
        }
        if (j < column - 1) {
            search(count, i, j + 1);
        }
        if (i < row - 1) {
            search(count, i + 1, j);
        }
        if (j > 0) {
            search(count, i, j - 1);
        }
    }

}
