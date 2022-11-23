package geeksforgeeks.java.misc;

/*
 * Maximum Sum LCM : Daily > 23 Nove 2022
 */
public class Solution23 {
    static long maxSumLCM(int n) {
        // code here
        long ans = 0;
        int N = (int) Math.sqrt(n);
        for (int i = 1; i <= N; i++) {
            if (n % i == 0) {
                if (n / i == i)
                    ans += i;
                else
                    ans += i + n / i;
            }
        }
        return ans;
    }
}
