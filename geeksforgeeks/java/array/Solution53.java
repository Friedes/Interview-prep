package geeksforgeeks.java.array;

/*
 * Burst Balloons : 22 Dec 2022
 */
public class Solution53 {
    private static int[][] dp;

    private static int mcm(int[] v, int l, int r) {
        if (l >= r)
            return 0;
        else if (dp[l][r] != -1)
            return dp[l][r];
        int ans = 0;
        for (int i = l; i < r; i++) {
            ans = Math.max(ans, mcm(v, l, i) + mcm(v, i + 1, r) + v[l - 1] * v[i] * v[r]);
        }
        return dp[l][r] = ans;
    }

    public static int maxCoins(int N, int[] arr) {
        int[] v = new int[N + 2];
        v[0] = v[N + 1] = 1;
        for (int i = 0; i < N; i++)
            v[i + 1] = arr[i];
        
        dp = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++)
            for (int j = 0; j < N + 2; j++)
                dp[i][j] = -1;

        return mcm(v, 1, N + 1);
    }
}
