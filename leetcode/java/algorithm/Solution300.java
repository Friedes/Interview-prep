package leetcode.java.algorithm;

import java.util.Arrays;

/*
 * Longest Increasing Subsequence : Algorithm Day 16 > 16 Dec 2022
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int lastFilledTailLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int index = binarySearch(key, dp, i);
            lastFilledTailLength = Math.max(lastFilledTailLength, index + 1);
            dp[index] = key;
        }
        return lastFilledTailLength;
    }

    private int binarySearch(int key, int[] dp, int end) {
        int lo = 0;
        int hi = end;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] == key) {
                return mid;
            } else if (key < dp[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
