package leetcode.java.twopointers;

/*
 * Remove Duplicates from Sorted Array : Challenge > 11 Nov 2022
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
