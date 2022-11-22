package leetcode.java.dp;

/*
 * Perfect Squares : Daily 22 Nov 2022
 */
public class Solution279 {
    public int numSquares(int n) {
        return numSq(n);
    }

    public int numSq(int n) {
        if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n))) {
            return 1;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int num = 1; num * num <= n; num++) {
            int base = (int) Math.sqrt(n - num * num);
            if (base * base == (n - num * num)) {
                return 2;
            }
        }
        return 3;
    }
}
