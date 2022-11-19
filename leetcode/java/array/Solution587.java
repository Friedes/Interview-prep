package leetcode.java.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/*
 * Erect the Fence : Daily 19 Nov 2022
 */
public class Solution587 {
    public int[][] outerTrees(int[][] trees) {
        if (trees == null || trees.length == 0)
            return new int[][] {};
        Arrays.sort(trees, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < trees.length; i++) {
            while (stack.size() >= 2 && crossProduct(stack.get(stack.size() - 2), stack.peek(), trees[i]) > 0) {
                stack.pop();
            }
            stack.push(trees[i]);
        }
        stack.pop();
        for (int i = trees.length - 1; i >= 0; i--) {
            while (stack.size() >= 2 && crossProduct(stack.get(stack.size() - 2), stack.peek(), trees[i]) > 0) {
                stack.pop();
            }
            stack.push(trees[i]);
        }
        Set<int[]> set = new HashSet<>(stack);
        Iterator<int[]> iterator = set.iterator();
        int[][] ans = new int[set.size()][2];
        for (int i = 0; i < set.size(); i++)
            ans[i] = iterator.next();
        return ans;
    }

    private int crossProduct(int[] o, int[] p, int[] q) {
        return (p[1] - o[1]) * (q[0] - o[0]) - (q[1] - o[1]) * (p[0] - o[0]);
    }
}
