package leetcode.java.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Shortest Path in Binary Matrix : Algorithm Day 8 > 8 Dec 2022
 */
public class Solution1091 {
    int[][] directions = new int[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
            { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            int count = p[2];

            if (i == n - 1 && j == n - 1)
                return count;
            for (int[] d : directions) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                    q.add(new int[] { x, y, count + 1 });
                    grid[x][y] = 1;
                }
            }

        }
        return -1;
    }
}
