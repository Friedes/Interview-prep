package geeksforgeeks.java.array;

/*
 * Magic Triplets : 21 Nov 2022
 */
public class Solution22 {
    public int countTriplets(int[] nums) {
        // code here
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i])
                    right++;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    left++;
            }
            x = x + left * right;
        }
        return x;
    }
}
