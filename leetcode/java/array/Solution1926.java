package leetcode.java.array;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Nearest Exit from Entrance in Maze : Daily 21 Nov 2022
 */
public class Solution1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dirs = { 0, 1, 0, -1, 0 };
        int level = 0;

        queue.add(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nextX = cell[0] + dirs[k];
                    int nextY = cell[1] + dirs[k + 1];

                    if (nextX < 0 || nextX >= m ||
                            nextY < 0 || nextY >= n)
                        continue;

                    if (visited[nextX][nextY]
                            || maze[nextX][nextY] == '+')
                        continue;

                    if (nextX == 0 || nextX == m - 1 ||
                            nextY == 0 || nextY == n - 1)
                        return level + 1;

                    queue.add(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
