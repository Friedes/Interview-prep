package geeksforgeeks.java.math;

import java.util.Arrays;

/*
 * Fill up buckets > Daily : 13 Nove 2022
 */
public class Solution13 {
    public int totalWays(int n, int[] capacity) {
        // code here
        Arrays.sort(capacity);
        long diff = 0;
        long ans = 1;
        for (int x : capacity) {
            if (x - diff <= 0)
                return 0;
            ans *= (x - diff);
            ans = ans % 1000000007;
            diff++;
        }
        return (int) ans;
    }
}
