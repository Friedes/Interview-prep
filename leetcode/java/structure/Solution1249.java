package leetcode.java.structure;

import java.util.Stack;

/*
 * Minimum Remove to Make Valid Parentheses : Data structure Day 14 > 14 Nov 2022
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(')
                st.push(i);
            else if (ch[i] == ')') {
                if (st.isEmpty())
                    ch[i] = '#';
                else
                    st.pop();
            }

        }
        while (!st.isEmpty())
            ch[st.pop()] = '#';

        StringBuffer res = new StringBuffer();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') {
                res.append(ch[i]);
            }
        }
        return res.toString();
    }
}
