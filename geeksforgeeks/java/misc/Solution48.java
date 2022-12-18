package geeksforgeeks.java.misc;

/*
 * A Game of LCM : Daily > 18 Dec 2022
 */
public class Solution48 {
    long maxGcd(int N) {
        // code here
        long ans = -1;
        boolean b = true;
        while (b) {
            long res = N * (N - 1);
            int c = 0;
            for (long i = N - 2; i > 2 && c < 2; i--) {
                if (gcd(res, i) == 1) {
                    res *= i;
                    c++;
                }
            }
            ans = Math.max(ans, res);
            if (N % 2 == 1)
                b = false;
            else
                N = N - 1;
        }
        return ans;
    }

    long gcd(long ans, long n) {
        if (n == 0)
            return ans;
        return gcd(n, ans % n);
    }
}
