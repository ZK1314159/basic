package leetcode;

/**
 * Description：<br>
 * 9:24 开始读题
 * 9:34 想到算法
 * 10:33 写完算法
 * 11:24 算法AC
 * 12:35 官方算法AC
 * CreateDate：2022/3/15 11:46 <br>
 */
public class Exist_79_standard {
    boolean[][] history;
    int rows;
    int columns;

    public boolean exist(char[][] board, String word) {
        char head = word.charAt(0);
        rows = board.length;
        columns = board[0].length;
        history = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns ; j++) {
                if (board[i][j] == head) {
                    if (check(i, j, 0, word, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean check(int row, int column, int position, String word, char[][] board) {
        if (board[row][column] != word.charAt(position)) {
            return false;
        }
        if (position == word.length() - 1) {
            return true;
        }

        history[row][column] = true;
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow >= 0 && newRow <= rows - 1 && newColumn >= 0 & newColumn <= columns - 1) {
                if (!history[newRow][newColumn]) {
                    boolean hasWord = check(newRow, newColumn, position + 1, word, board);
                    if (hasWord) {
                        return true;
                    }
                }
            }
        }

        history[row][column] = false;
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        char[][] board = new char[][] {{'a'},{'a'}};
        String word = "aaa";
//        char[][] board = new char[][] {{'a', 'b'},{'c', 'd'}};
//        String word = "dbac";
//        char[][] board = new char[][] {{'A', 'B', 'E'},{'B', 'C', 'D'}};
//        String word = "ABCDEB";
        Exist_79_standard test = new Exist_79_standard();
        boolean answer = test.exist(board, word);
    }

}
