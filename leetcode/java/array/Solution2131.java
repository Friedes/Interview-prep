package leetcode.java.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Longest Palindrome by Concatenating Two Letter Words : Challenge > 3 Nov 2022
 */
public class Solution2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String s = "";
            s += words[i].charAt(1);
            s += words[i].charAt(0);
            if (map.containsKey(s) && map.get(s) != 0) {
                if (map.get(s) >= 1)
                    count += 4;
                map.put(s, map.getOrDefault(s, 0) - 1);

            } else {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }

        for (Entry<String, Integer> e : map.entrySet()) {
            String s = e.getKey();
            if (s.charAt(0) == s.charAt(1) && e.getValue() == 1) {
                count += 2;
                break;
            }
        }

        return count;
    }
}
