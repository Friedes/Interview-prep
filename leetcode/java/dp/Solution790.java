package leetcode.java.dp;

/*
 * Domino and Tromino Tiling : Daily 24  Nov 2022
 */
public class Solution790 {
    public int numTilings(int n) {
        if (n <= 2)
            return n;
        long dp[] = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int i;
        long m = 1000000007;
        for (i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % m;
        }
        return (int) (dp[n] % m);
    }
}
