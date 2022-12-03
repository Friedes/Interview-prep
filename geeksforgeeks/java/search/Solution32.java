package geeksforgeeks.java.search;

import java.util.Arrays;

/*
 * Aggressive Cows : 2 Dec 2022
 */
public class Solution32 {
    public static int solve(int n, int k, int[] stalls) {
        int low = 0, high = 1000000000, ans = 0;
        Arrays.sort(stalls);
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, mid, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int mid, int k, int n) {
        int count = 1, prevPos = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - prevPos >= mid) {
                count++;
                if (count == k)
                    return true;
                prevPos = arr[i];
            }
        }
        return false;
    }
}
