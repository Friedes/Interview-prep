package leetcode.java.array;

import java.util.PriorityQueue;

/*
 * Longest Subsequence With Limited Sum : Daily 25 Dec 2022
 */
public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        int k = 0;
        for (int max : queries) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            int sum = 0;
            for (int n : nums) {
                if (sum + n > max) {
                    if (!pq.isEmpty() && pq.peek() > n) {
                        sum -= pq.remove();
                        sum += n;
                        pq.add(n);
                    }
                } else {
                    sum += n;
                    pq.add(n);
                }
            }
            res[k++] = pq.size();
        }
        return res;
    }
}
