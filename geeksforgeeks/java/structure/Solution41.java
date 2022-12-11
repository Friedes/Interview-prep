package geeksforgeeks.java.structure;

/*
 * Array Pair Sum Divisibility Problem : Daily > 11 Dec 2022
 */
public class Solution41 {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int n = nums.length;
        int[] freq = new int[k + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i] % k]++;
        }

        for (int i = 0; i < n; i++) {
            int rem = nums[i] % k;

            if (rem == 0) {
                if (freq[rem] == 0 || freq[rem] % 2 != 0) {
                    return false;
                }
            } else if (2 * rem == k) {
                if (freq[rem] == 0 || freq[rem] % 2 != 0) {
                    return false;
                }
            } else {
                if (freq[rem] == 0 || freq[k - rem] == 0 || freq[rem] != freq[k - rem]) {
                    return false;
                }
            }
        }

        return true;
    }
}
