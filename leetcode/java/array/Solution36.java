package leetcode.java.array;

import java.util.HashSet;

/*
 * Valid Sudoku : Daily > 23 Nov 2022
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    if (!hs.add(board[i][j] + "row" + i) ||
                            !hs.add(board[i][j] + "column" + j) ||
                            !hs.add(board[i][j] + "subBox" + i / 3 + ":" + j / 3))
                        return false;
                }

        return true;
    }
}
