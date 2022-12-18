package leetcode.java.algorithm;

/*
 * Integer Break : Algorithm Day 18 > 18 Dec 2022
 */
public class Solution343 {
    public int integerBreak(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        for (int i = 0; i <= 4; i += 2) {
            int powerPart = 0;
            if ((n - i) % 3 == 0) {
                powerPart = (int) Math.pow(3, (n - i) / 3);
                return i == 0 ? powerPart : powerPart * i;
            }
        }
        return -1;
    }
}
