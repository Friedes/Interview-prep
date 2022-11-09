package geeksforgeeks.java.dp;

/*
 * Minimum sum partition : 09 Nov 2022
 */
public class Solution09 {
    public int minDifference(int arr[], int n) {
        // Code here
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] t = new boolean[n + 1][sum];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < sum; i++) {
            if (t[n][i]) {
                mini = Math.min(mini, Math.abs(sum - 2 * i));
            }
        }
        return mini;
    }
}
