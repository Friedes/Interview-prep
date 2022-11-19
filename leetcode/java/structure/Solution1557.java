package leetcode.java.structure;

import java.util.ArrayList;
import java.util.List;

/*
 * Minimum Number of Vertices to Reach All Nodes : Data structure Day 19 > 19 Nov 2022
 */
public class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] indegree = new int[n];
        for (List<Integer> e : edges) {
            indegree[e.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
