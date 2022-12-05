package leetcode.java.algorithm;

/*
 * Subarray Product Less Than K : Algorithm Day 5 > 5 Dec 2022
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}
