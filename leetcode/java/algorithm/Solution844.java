package leetcode.java.algorithm;

/*
 * Backspace String Compare : Algorithm Day 4 > 4 Dec 2022
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s.isEmpty() || t.isEmpty())
            return false;

        String s1 = process(s);
        String s2 = process(t);
        return s1.equals(s2);
    }

    String process(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
