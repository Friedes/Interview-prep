package leetcode.java.structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Repeated DNA Sequences : Data structure Day 9 > 09 Nov 2022
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        HashMap<String, Integer> check = new HashMap<>();
        String cur;
        int i;
        for (i = 0; i < s.length() - 9; i++) {
            cur = s.substring(i, i + 10);
            if (check.containsKey(cur) && check.get(cur) == 1) {
                result.add(cur);
            }
            check.put(cur, check.getOrDefault(cur, 0) + 1);
        }
        return result;
    }
}
