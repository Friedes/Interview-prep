package leetcode.java.structure;

import java.util.Arrays;

/*
 * Non-overlapping Intervals : Data structure Day 4 > 04 Nov 2022
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                count++;
                end = Math.min(intervals[i][1], end);
            }
        }

        return count;
    }
}
