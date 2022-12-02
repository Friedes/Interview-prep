package leetcode.java.algorithm;

/*
 * Find Minimum in Rotated Sorted Array : Algorithm Day 2 > 2 Dec 2022
 */
public class Solution153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid;
            else
                right = mid;
        }
        if (nums[left] > nums[right])
            return nums[right];
        return nums[left];
    }
}
