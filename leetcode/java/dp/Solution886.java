package leetcode.java.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Possible Bipartition : Daily 21 Dec 2022
 */
public class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : dislikes) {
            graph[pair[0] - 1].add(pair[1] - 1);
            graph[pair[1] - 1].add(pair[0] - 1);
        }

        int[] col = new int[n];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int cur = q.remove();
                    for (int j = 0; j < graph[cur].size(); j++) {
                        int des = graph[cur].get(j);
                        if (col[des] == -1) {
                            int nextCol = col[cur] == 0 ? 1 : 0;
                            col[des] = nextCol;
                            q.add(des);
                        } else if (col[des] == col[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
