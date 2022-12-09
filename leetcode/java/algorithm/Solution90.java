package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Subsets II : Algorithm Day 9 > 9 Dec 2022
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        if (temp.size() <= nums.length) {
            res.add(new ArrayList<Integer>(temp));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrack(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
