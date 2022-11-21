package leetcode.java.structure;

import java.util.PriorityQueue;

/*
 * K Closest Points to Origin : Data structure Day 21 > 21 Nov 2022
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));

        for (int[] point : points) {
            minHeap.offer(point);
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
