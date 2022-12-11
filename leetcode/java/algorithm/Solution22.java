package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * Generate Parentheses : Algorithm Day 11 > 11 Dec 2022
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        char[] comb = new char[2 * n];
        genComb(comb, 0, 0, list);
        return list;
    }

    public void genComb(char[] comb, int i, int valid, ArrayList<String> list) {
        if (i == comb.length && valid == 0) {
            list.add(new String(comb));
        } else if (i != comb.length && valid >= 0 && valid <= comb.length / 2) {
            comb[i] = '(';
            genComb(comb, i + 1, valid + 1, list);
            comb[i] = ')';
            genComb(comb, i + 1, valid - 1, list);
        }
    }
}
