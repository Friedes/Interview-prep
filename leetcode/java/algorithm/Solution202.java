package leetcode.java.algorithm;

import java.util.HashSet;

/*
 * Happy Number : Algorithm Day 21 > 21 Dec 2022
 */
public class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
}
