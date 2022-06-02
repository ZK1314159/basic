package leetcode;

/**
 * Description：<br>
 * 15:53 开始看题
 * 16:07 想到解法
 * 16:39 写完解法
 * 16:39 解法AC
 * 17:18 官方解法AC
 * CreateDate：2022/6/2 16:08 <br>
 */
public class NumIslands_200_standard {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    search(grid, i, j);
                }
            }
        }
        return count;
    }

    void search(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        search(grid, i - 1, j);
        search(grid, i, j + 1);
        search(grid, i + 1, j);
        search(grid, i, j - 1);
    }

}
