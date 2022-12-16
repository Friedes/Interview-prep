package leetcode.java.algorithm;

import java.util.Arrays;

/*
 * Number of Longest Increasing Subsequence : Algorithm Day 16 > 16 Dec 2022
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] cnt = new int[nums.length];
        Arrays.fill(cnt, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    cnt[i] = cnt[j];
                } else if (nums[j] < nums[i] && 1 + dp[j] == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        int rtn = 0;
        for (int i = 0; i < cnt.length; i++)
            if (dp[i] == ans)
                rtn += cnt[i];
        return rtn;
    }
}
