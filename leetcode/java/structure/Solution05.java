package leetcode.java.structure;

/*
 * Longest Palindromic Substring : Data structure Day 9 > 09 Nov 2022
 */
public class Solution05 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i))
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                    }
                if (dp[i][j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
