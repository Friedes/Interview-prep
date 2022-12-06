package geeksforgeeks.java.dp;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Distance of nearest cell having 1 : Daily 06 Dec 2022
 */
public class Solution36 {
    public int[][] nearest(int[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> qe = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    qe.add(new int[] { i, j });
                } else
                    grid[i][j] = -1;
            }
        }

        while (!qe.isEmpty()) {
            int ns = qe.size();
            while (ns-- > 0) {
                int[] a = qe.poll();
                for (int[] dir : dirs) {
                    int nr = a[0] + dir[0];
                    int nc = a[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == -1) {
                        grid[nr][nc] = 1 + grid[a[0]][a[1]];
                        qe.add(new int[] { nr, nc });
                    }
                }
            }
        }
        return grid;
    }
}
