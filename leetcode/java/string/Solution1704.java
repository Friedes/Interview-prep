package leetcode.java.string;

/*
 * Basic Calculator : Daily 1 Dec 2022
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        int left = 0, right = s.length() - 1, leftVowels = 0, rightVowels = 0;
        String str = "aeiouAEIOU";
        while (left < right) {
            if (str.indexOf(s.charAt(left++)) != -1)
                leftVowels++;
            if (str.indexOf(s.charAt(right--)) != -1)
                rightVowels++;
        }
        return leftVowels == rightVowels;
    }
}
