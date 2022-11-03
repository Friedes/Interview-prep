package leetcode.java.structure;

import java.util.Arrays;
import java.util.Stack;

import leetcode.java.Solution;

/*
 * Merge Intervals : Data structure Day 2 > 02 Nov 2022
 */
public class Solution56 implements Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int[] interval : intervals) {
            if (stack.isEmpty() || interval[0] > stack.peek()[1]) {
                stack.push(interval);
            } else {
                stack.peek()[1] = Math.max(interval[1], stack.peek()[1]);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }

    public String testResult() {
        return "";
    }
}
