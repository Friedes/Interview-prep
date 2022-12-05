package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find All Anagrams in a String : Algorithm Day 5 > 5 Dec 2022
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] search = new int[26];
        int[] window = new int[26];
        List<Integer> result = new ArrayList<>();
        for (char ch : p.toCharArray())
            search[ch - 'a']++;

        int startWindow = 0;

        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            window[s.charAt(endWindow) - 'a']++;
            if (endWindow + 1 >= p.length()) {
                if (Arrays.equals(search, window))
                    result.add(startWindow);
                window[s.charAt(startWindow++) - 'a']--;
            }
        }
        return result;
    }
}
