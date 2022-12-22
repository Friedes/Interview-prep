package leetcode.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Sum of Distances in Tree : Daily 22 Dec 2022
 */
public class Solution834 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] res = new int[n];
        int[] sub = new int[n];
        boolean[] vis = new boolean[n];
        int[] sum = new int[1];
        sum[0] = 0;
        dfs(0, sub, vis, 0, adj, sum);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Arrays.fill(vis, false);
        res[0] = sum[0];
        vis[0] = true;

        while (queue.size() != 0) {
            int temp = queue.poll();

            for (Integer it : adj.get(temp)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    res[it] = res[temp] - (2 * sub[it]) + (n);
                    queue.add(it);
                }
            }
        }

        return res;
    }

    public int dfs(int i, int[] sub, boolean[] vis, int level, ArrayList<ArrayList<Integer>> adj, int[] sum) {
        sum[0] += level;
        vis[i] = true;
        int total = 0;

        for (Integer it : adj.get(i)) {
            if (!vis[it]) {
                total += dfs(it, sub, vis, level + 1, adj, sum);
            }
        }

        sub[i] = total + 1;
        return sub[i];
    }
}
