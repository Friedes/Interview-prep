package leetcode.java.structure;

/*
 * Min Stack : Data structure Day 14 > 14 Nov 2022
 */
public class Solution155 {
    int[] stack;
    int top = -1;
    int[] minStack;
    int minTop = 0;

    // public MinStack() {
    public Solution155() {
        stack = new int[30000];
        minStack = new int[30000];
        minStack[0] = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack[++top] = val;
        if (minStack[minTop] >= val)
            minStack[++minTop] = val;
    }

    public void pop() {
        if (stack[top] == minStack[minTop])
            minTop--;
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minTop];
    }
}
