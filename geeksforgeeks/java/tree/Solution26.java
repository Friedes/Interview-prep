package geeksforgeeks.java.tree;

import java.util.HashMap;
import java.util.Stack;

/*
 * Construct Binary Tree from String with bracket representation : Daily > 26 Nov 2022
 */
public class Solution26 {
    private static Node rec(int st, int end, String s, HashMap<Integer, Integer> map) {
        if (st > end)
            return null;
        String num = "";
        while (st <= end && s.charAt(st) >= '0' && s.charAt(st) <= '9')
            num += s.charAt(st++);
        st--;
        int r_val = Integer.parseInt(num);
        Node root = new Node(r_val);
        int left_end = map.getOrDefault(st + 1, Integer.MIN_VALUE);
        if (left_end >= 0)
            root.left = rec(st + 2, left_end - 1, s, map);
        int right_end = map.getOrDefault(left_end + 1, Integer.MIN_VALUE);
        if (right_end >= 0)
            root.right = rec(left_end + 2, right_end - 1, s, map);
        return root;
    }

    public static Node treeFromString(String s) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                int x = st.pop();
                map.put(x, i);
            }
        }
        return rec(0, n - 1, s, map);
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
