package leetcode.java.math;

/*
 * Ugly Number : Daily 18 Nov 2022
 */
public class Solution263 {
    public boolean isUgly(int n) {
        for (int i = 2; i < 6 && n > 0; i++)
            while (n % i == 0)
                n /= i;
        return n == 1;
    }
}
