package leetcode.java.algorithm;

/*
 * Number of Provinces : Algorithm Day 6 > 6 Dec 2022
 */
public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int numberOfProvinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, i, isVisited);
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }

    private void dfs(int[][] isConnected, int source, boolean[] isVisited) {
        isVisited[source] = true;
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
            if (!isVisited[neighbour] && isConnected[source][neighbour] == 1) {
                dfs(isConnected, neighbour, isVisited);
            }
        }
    }
}
