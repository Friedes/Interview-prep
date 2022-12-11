package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * Letter Combinations of a Phone Number : Algorithm Day 11 > 11 Dec 2022
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits.length() == 0)
            return list;

        String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        comb(digits, 0, "", map);
        return list;
    }

    List<String> list;

    public void comb(String digits, int i, String ans, String[] map) {
        if (i >= digits.length()) {
            list.add(ans);
            return;
        }

        String str = map[digits.charAt(i) - '0'];

        for (int j = 0; j < str.length(); j++)
            comb(digits, i + 1, ans + str.charAt(j), map);
    }
}
