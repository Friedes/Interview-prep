package geeksforgeeks.java.dp;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Jumping Numbers : 10 Nov 2022
 */
public class Solution10 {
    public static long jumpingNums(long X) {
        // code here
        Queue<Long> q = new LinkedList<>();
        for (long i = 1; i <= 9; i++) {
            q.offer(i);
        }
        long max = Long.MIN_VALUE;
        while (q.size() > 0) {
            long nd = q.remove();
            if (nd > X)
                continue;
            else
                max = Math.max(max, nd);
            long rem = nd % 10;
            if (rem != 9) {
                long num = nd * 10 + rem + 1;
                q.offer(num);
            }
            if (rem != 0) {
                long num = nd * 10 + rem - 1;
                q.offer(num);
            }
        }
        return max;
    }
}
