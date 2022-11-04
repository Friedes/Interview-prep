package leetcode.java.twopointers;

import java.util.ArrayList;

/*
 * Reverse Vowels of a String : Challenge > 4 Nov 2022
 */
public class Solution345 {
    public String reverseVowels(String s) {
        ArrayList<Integer> vowelsIndexs = new ArrayList<>();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i) + "")) {
                vowelsIndexs.add(i);
            }
        }
        if (vowelsIndexs.size() == 0) {
            return s;
        }
        int i = 0;
        int j = vowelsIndexs.size() - 1;
        char c[] = s.toCharArray();
        while (i < j) {
            char temp = c[vowelsIndexs.get(i)];
            c[vowelsIndexs.get(i)] = c[vowelsIndexs.get(j)];
            c[vowelsIndexs.get(j)] = temp;
            i++;
            j--;
        }

        return new String(c);
    }
}
