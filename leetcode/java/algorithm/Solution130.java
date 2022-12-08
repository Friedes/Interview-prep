package leetcode.java.algorithm;

/*
 * Surrounded Regions : Algorithm Day 8 > 8 Dec 2022
 */
public class Solution130 {
    public void spread(char[][] board, int i, int j, int dir[][]) {
        board[i][j] = '$';
        for (int d = 0; d < 4; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O') {
                spread(board, x, y, dir);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1)
                    if (board[i][j] == 'O')
                        spread(board, i, j, dir);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '$')
                    board[i][j] = 'O';
            }
        }
    }
}
