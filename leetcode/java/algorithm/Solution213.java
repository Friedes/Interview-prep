package leetcode.java.algorithm;

/*
 * House Robber II : Algorithm Day 12 > 12 Dec 2022
 */
public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        if (n == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int dp2[] = new int[n - 1];
        int dp1[] = new int[n - 1];
        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(nums[i + 1] + dp1[i - 2], dp1[i - 1]);
        }
        return Math.max(dp1[n - 2], dp2[n - 2]);
    }
}
