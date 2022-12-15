package leetcode.java.algorithm;

import java.util.Arrays;

/*
 * Decode Ways : Algorithm Day 15 > 15 Dec 2022
 */
public class Solution91 {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numWays(s, s.length() - 1, memo);
    }

    private int numWays(String str, int index, int[] memo) {
        if (index < 0)
            return 1;
        if (memo[index] != -1)
            return memo[index];
        int res = (str.charAt(index) == '0') ? 0 : numWays(str, index - 1, memo);
        if (index > 0 && str.charAt(index - 1) == '1') {
            res += numWays(str, index - 2, memo);
        } else if (index > 0 && str.charAt(index - 1) == '2' && str.charAt(index) <= '6') {
            res += numWays(str, index - 2, memo);
        }
        memo[index] = res;
        return res;
    }
}
