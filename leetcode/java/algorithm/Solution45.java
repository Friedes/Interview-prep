package leetcode.java.algorithm;

/*
 * Jump Game II : Algorithm Day 13 > 13 Dec 2022
 */
public class Solution45 {
    public int jump(int[] nums) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == e) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
}
