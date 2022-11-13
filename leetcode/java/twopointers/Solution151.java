package leetcode.java.twopointers;

/*
 * Reverse Words in a String : Challenge > 13 Nov 2022
 */
public class Solution151 {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (j != i)
                sb.append(s.substring(i + 1, j + 1) + " ");
        }
        sb.setLength((sb.length() - 1));
        return sb.toString();
    }
}
