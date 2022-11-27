package leetcode.java.dp;

import java.util.HashMap;

/*
 * Arithmetic Slices II - Subsequence : Daily 27 Nov 2022
 */
public class Solution446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int re = 0;
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<Integer, Integer>();
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if ((long) num - nums[j] > Integer.MAX_VALUE)
                    continue;
                if ((long) num - nums[j] < Integer.MIN_VALUE)
                    continue;
                int diff = num - nums[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);
                re += count;
            }
        }
        return re;
    }
}
