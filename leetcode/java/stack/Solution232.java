package leetcode.java.stack;

import java.util.Stack;

/*
 * Implement Queue using Stacks : Daily 09 Nov 2022
 */
public class Solution232 {

    private Stack<Integer> s = new Stack<Integer>();
    private Stack<Integer> t = new Stack<Integer>();

    // public MyQueue()
    public Solution232() {}

    public void push(int x) {
        while (!s.isEmpty())
            t.push(s.pop());
        s.push(x);
        while (!t.isEmpty())
            s.push(t.pop());
    }

    public int pop() {
        return s.pop();
    }

    public int peek() {
        return s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }
}
