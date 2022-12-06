package leetcode.java.algorithm;

/*
 * Number of Islands : Algorithm Day 6 > 6 Dec 2022
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    count += 1;
                    traverseIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public void traverseIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        traverseIsland(grid, i + 1, j);
        traverseIsland(grid, i - 1, j);
        traverseIsland(grid, i, j - 1);
        traverseIsland(grid, i, j + 1);
    }
}
