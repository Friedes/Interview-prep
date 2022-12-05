package geeksforgeeks.java.dp;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Longest Bitonic subsequence : Daily 05 Dec 2022
 */
public class Solution35 {
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, k });
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();

                if (curr[0] == n - 1 && curr[1] == m - 1)
                    return steps;

                for (int[] d : dir) {
                    int i = curr[0] + d[0];
                    int j = curr[1] + d[1];
                    int obs = curr[2];

                    if (i >= 0 && i < n && j >= 0 && j < m) {
                        if (mat[i][j] == 0 && !visited[i][j][obs]) {
                            q.offer(new int[] { i, j, obs });
                            visited[i][j][obs] = true;
                        } else if (mat[i][j] == 1 && obs > 0 && !visited[i][j][obs - 1]) {
                            q.offer(new int[] { i, j, obs - 1 });
                            visited[i][j][obs - 1] = true;
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
