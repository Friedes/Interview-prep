package leetcode.java.algorithm;

/*
 * Word Search : Algorithm Day 11 > 11 Dec 2022
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (find(i, j, board, word, 0, new boolean[board.length][board[0].length]))
                        return true;
            }
        }
        return false;
    }

    public boolean find(int i, int j, char[][] board, String word, int k, boolean[][] filled) {
        if (k == word.length())
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || filled[i][j] == true)
            return false;
        if (board[i][j] == word.charAt(k)) {
            filled[i][j] = true;
            if (find(i + 1, j, board, word, k + 1, filled))
                return true;
            if (find(i - 1, j, board, word, k + 1, filled))
                return true;
            if (find(i, j + 1, board, word, k + 1, filled))
                return true;
            if (find(i, j - 1, board, word, k + 1, filled))
                return true;
            filled[i][j] = false;
        }
        return false;
    }
}
