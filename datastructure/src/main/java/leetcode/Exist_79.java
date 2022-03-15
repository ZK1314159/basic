package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/15 9:36 <br>
 */
public class Exist_79 {

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
                    history[i][j] = true;
                    if (check(i, j, 1, word, board)) {
                        return true;
                    }
                    history[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean check(int row, int column, int i, String word, char[][] board) {
        if (i == word.length()) {
            return true;
        }
        if (row > 0 && !history[row - 1][column] && board[row - 1][column] == word.charAt(i)) {
            history[row - 1][column] = true;
            boolean hasWord = check(row - 1, column, i + 1, word, board);
            if (hasWord) {
                return true;
            }
            history[row - 1][column] = false;
        }
        if (column < columns - 1 && !history[row][column + 1] && board[row][column + 1] == word.charAt(i)) {
            history[row][column + 1] = true;
            boolean hasWord = check(row, column + 1, i + 1, word, board);
            if (hasWord) {
                return true;
            }
            history[row][column + 1] = false;
        }
        if (row < rows - 1 && !history[row + 1][column] && board[row + 1][column] == word.charAt(i)) {
            history[row + 1][column] = true;
            boolean hasWord = check(row + 1, column, i + 1, word, board);
            if (hasWord) {
                return true;
            }
            history[row + 1][column] = false;
        }
        if (column > 0 && !history[row][column - 1] && board[row][column - 1] == word.charAt(i)) {
            history[row][column - 1] = true;
            boolean hasWord = check(row, column - 1, i + 1, word, board);
            if (hasWord) {
                return true;
            }
            history[row][column - 1] = false;
        }

        return false;
    }

//    public String merge(int i, int j, int k) {
//        return i + "_" + j + "_" + k;
//    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char[][] board = new char[][] {{'a'},{'a'}};
//        String word = "aaa";
//        char[][] board = new char[][] {{'a', 'b'},{'c', 'd'}};
//        String word = "dbac";
//        char[][] board = new char[][] {{'A', 'B', 'E'},{'B', 'C', 'D'}};
//        String word = "ABCDEB";
        Exist_79 test = new Exist_79();
        boolean answer = test.exist(board, word);
    }

}
