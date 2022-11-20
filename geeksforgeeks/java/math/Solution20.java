package geeksforgeeks.java.math;

/*
 * LCM Triplet > Daily : 20 Nove 2022
 */
public class Solution20 {

    long lcmTriplets(long N) {
        if (N <= 2)
            return N;
        else if (N % 2 == 0 && N % 3 == 0)
            return (N - 1) * (N - 2) * (N - 3);
        else if (N % 2 == 0)
            return N * (N - 1) * (N - 3);
        return N * (N - 1) * (N - 2);
    }
}
