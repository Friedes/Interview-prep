package leetcode.java.dp;

import java.util.HashMap;
import java.util.Map;

import leetcode.java.Solution;

/*
 * Most Stones Removed with Same Row or Column : Daily 14 Nov 2022
 */
public class Solution947 implements Solution {

    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    int count = 0;

    private int findParent(int x) {
        if (parent.getOrDefault(x, 0) != x)
            parent.put(x, findParent(parent.getOrDefault(x, 0)));
        return parent.get(x);
    }

    private void union(int r, int c) {
        int xSet = findParent(r), ySet = findParent(c);

        if (xSet == ySet)
            return;

        count--;

        if (rank.getOrDefault(xSet, 0) < rank.getOrDefault(ySet, 0))
            parent.put(xSet, ySet);

        else if (rank.getOrDefault(xSet, 0) > rank.getOrDefault(ySet, 0))
            parent.put(ySet, xSet);

        else {
            parent.put(ySet, xSet);
            rank.put(xSet, rank.getOrDefault(ySet, 0) + 1);
        }
    }

    public int removeStones(int[][] stones) {
        for (int[] c : stones) {
            int row = -(c[0] + 1);
            int col = (c[1] + 1);

            parent.put(row, row);
            parent.put(col, col);
        }
        count = parent.size();

        for (int[] c : stones) {
            int row = -(c[0] + 1);
            int col = (c[1] + 1);

            union(row, col);
        }
        
        return stones.length - count;
    }

    public String testResult() {
        return "";
    }
}
