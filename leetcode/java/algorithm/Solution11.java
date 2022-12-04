package leetcode.java.algorithm;

/*
 * Container With Most Water : Algorithm Day 4 > 4 Dec 2022
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int cm, x;
        int n = height.length;
        int l = 0, r = n - 1;
        int mm = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] < height[r]) {
                x = l;
                do {
                    l++;
                } while (height[l] < height[x] && l<r);
            } else {
                x = r;
                do {
                    r--;
                } while (height[r] < height[x] && l<r);
            }
            cm = Math.min(height[l], height[r]) * (r - l);
            mm = Math.max(cm, mm);
        }
        return mm;
    }
}
