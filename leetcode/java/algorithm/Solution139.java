package leetcode.java.algorithm;

import java.util.Arrays;
import java.util.List;

/*
 * Word Break : Algorithm Day 15 > 15 Dec 2022
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        byte[] dp = new byte[s.length()];
        Arrays.fill(dp, (byte) -1);

        return wordBreak(s, 0, wordDict, dp);
    }

    private boolean wordBreak(String s, int index, List<String> wordDict, byte[] dp) {
        if (index >= s.length())
            return true;

        if (dp[index] != -1)
            return dp[index] == 1;

        byte match = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, index) && wordBreak(s, index + word.length(), wordDict, dp)) {
                match = 1;
                break;
            }
        }

        dp[index] = match;

        return match == 1;
    }
}
