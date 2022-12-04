package geeksforgeeks.java.string;

import java.util.TreeMap;

/*
 * Alternate Vowel and Consonant String : Daily > 4 Dec 2022
 */
public class Solution34 {
    private static boolean isVowel(char ch) {
        return "aeiou".contains("" + ch);
    }

    public String rearrange(String S, int N) {
        TreeMap<Character, Integer> vowels = new TreeMap<>();
        TreeMap<Character, Integer> consonants = new TreeMap<>();

        int v_c = 0, c_c = 0;

        for (char ch : S.toCharArray()) {
            if (isVowel(ch)) {
                int v = vowels.getOrDefault(ch, 0);
                vowels.put(ch, v + 1);
                v_c++;
            } else {
                int v = consonants.getOrDefault(ch, 0);
                consonants.put(ch, v + 1);
                c_c++;
            }
        }

        boolean st = false;

        if (v_c - c_c > 1 || c_c - v_c > 1)
            return "-1";
        else if (v_c > c_c || v_c == c_c)
            st = true;
        else
            st = false;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char ch = 'x';
            if (st) {
                ch = vowels.firstKey();
                int freq = vowels.get(ch);
                if (freq == 1)
                    vowels.remove(ch);
                else
                    vowels.put(ch, freq - 1);
            } else {
                ch = consonants.firstKey();
                int freq = consonants.get(ch);
                if (freq == 1)
                    consonants.remove(ch);
                else
                    consonants.put(ch, freq - 1);
            }

            st = !st;
            ans.append(ch);
        }

        return ans.toString();
    }
}
