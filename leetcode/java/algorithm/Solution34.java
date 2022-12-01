package leetcode.java.algorithm;

/*
 * Find First and Last Position of Element in Sorted Array : Algorithm Day 1 > 1 Dec 2022
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int count = 0;
        int ini = 0, fin = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && count < 1) {
                ini = i;
                count++;
                flag = 1;
            }
            if (nums[i] == target && count >= 1) {
                fin = i;
                flag = 1;
            }
        }
        int[] a = new int[2];
        a[0] = ini;
        a[1] = fin;

        if ((ini == 0 && fin == 0) && flag == 0) {
            a[0] = -1;
            a[1] = -1;
        }
        return a;
    }
}
