package leetcode.java.algorithm;

import java.util.Random;

/*
 * Letter Combinations of a Phone Number : Algorithm Day 11 > 11 Dec 2022
 */
public class Solution384 {

    public Solution384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] randoms = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        int count = 0;
        while (count < randoms.length) {
            int index = random.nextInt(nums.length);
            if (!visited[index]) {
                randoms[count++] = nums[index];
                visited[index] = true;
            }
        }

        return randoms;
    }

    private int[] nums;
    private Random random;
}
