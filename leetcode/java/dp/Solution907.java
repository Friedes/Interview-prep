package leetcode.java.dp;

import java.util.Arrays;
import java.util.Stack;

/*
 * Sum of Subarray Minimums : Daily 25 Nov 2022
 */
public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int[] res = new int[arr.length];
        Arrays.fill(res, 0);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();

            if (!st.isEmpty())
                prev[i] = st.peek();
            st.push(i);
        }

        for (int i = 0; i < arr.length; i++)
            res[i] = (prev[i] < 0 ? 0 : res[prev[i]]) + (i - prev[i]) * arr[i];

        long sum = 0;
        int MOD = (int) Math.pow(10, 9) + 7;
        for (int i : res)
            sum = (sum % MOD) + i;

        return (int) sum;
    }
}
