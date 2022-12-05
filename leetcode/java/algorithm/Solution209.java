package leetcode.java.algorithm;

/*
 * Minimum Size Subarray Sum : Algorithm Day 5 > 5 Dec 2022
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (left < n - 1 && right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        if (nums[n - 1] == target)
            return 1;
        if (minLen == Integer.MAX_VALUE)
            return 0;

        return minLen;
    }
}
