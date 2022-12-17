package leetcode.java.algorithm;

/*
 * Delete Operation for Two Strings : Algorithm Day 17 > 17 Dec 2022
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (i > 0 && j > 0 && word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else if (i > 0 && j > 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return (word1.length() - dp[m][n]) + (word2.length() - dp[m][n]);
    }
}
