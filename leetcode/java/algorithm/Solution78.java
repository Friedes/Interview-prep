package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * Subsets : Algorithm Day 9 > 9 Dec 2022
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        backtrack(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        backtrack(res, cur, nums, index + 1);
    }
}
