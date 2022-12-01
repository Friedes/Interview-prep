package leetcode.java.algorithm;

/*
 * Search in Rotated Sorted Array : Algorithm Day 1 > 1 Dec 2022
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
