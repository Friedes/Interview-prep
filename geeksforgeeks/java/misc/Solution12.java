package geeksforgeeks.java.misc;

import java.util.HashMap;

/*
 * Maximum Sub-String after at most K changes : Dailt > 12 Nove 2022
 */
public class Solution12 {
    public int characterReplacement(String s, int k) {
        // code here
        int i = 0, j = 0, max = 0, ans = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            max = Math.max(max, map.getOrDefault(s.charAt(j), 0));
            if (j - i + 1 - max <= k) {
                ans = Math.max(max, j - i + 1);
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            j++;
        }
        return ans;
    }
}
