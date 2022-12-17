package geeksforgeeks.java.math;

/*
 * Break a number > Daily : 17 Dec 2022
 */
public class Solution47 {
    int waysToBreakNumber(int N) {
        // code here
        N++;
        return (int) ((((long) N * (long) (N + 1)) / 2L) % (1_000_000_007L));
    }
}
