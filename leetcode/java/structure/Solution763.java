package leetcode.java.structure;

import java.util.ArrayList;
import java.util.List;

/*
 * Partition Labels : Data structure Day 7 > 07 Nov 2022
 */
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++)
            index[s.charAt(i) - 'a'] = i;
        int startIndex = 0, lastIndex = 0, idx = 0;
        List<Integer> ans = new ArrayList<>();
        while (idx < s.length()) {
            lastIndex = index[s.charAt(idx) - 'a'];
            while (idx < lastIndex) {
                lastIndex = Math.max(lastIndex, index[s.charAt(idx) - 'a']);
                idx++;
            }
            ans.add(lastIndex - startIndex + 1);
            startIndex = ++idx;
        }
        return ans;
    }
}
