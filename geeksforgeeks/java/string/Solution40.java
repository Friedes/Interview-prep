package geeksforgeeks.java.string;

import java.util.Stack;

/*
 * Build the smallest : Daily > 10 Dec 2022
 */
public class Solution40 {
    static String buildLowestNumber(String str, int N) {
        // code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while (stack.size() > 0 && stack.peek() > c && N > 0) {
                N--;
                stack.pop();
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            char c = stack.pop();
            if (N > 0) {
                N--;
                continue;
            }
            sb.append(Character.toString(c));
        }

        String ans = sb.reverse().toString();
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0')
                return ans.substring(i);
        }
        return "0";
    }
}
