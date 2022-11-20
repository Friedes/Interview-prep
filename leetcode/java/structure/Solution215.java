package leetcode.java.structure;

/*
 * Kth Largest Element in an Array : Data structure Day 20 > 20 Nov 2022
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            max = Math.max(max, Math.abs(ele));
        }
        int[] arr = new int[2 * (max + 1)];
        int pos = max + 1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val < 0)
                val = pos - Math.abs(val);
            else
                val = pos + val;

            arr[val]++;
        }
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            count += arr[i];
            if (count >= k)
                return i - pos;
        }
        return 0;
    }
}
