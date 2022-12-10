package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum II : Algorithm Day 10 > 10 Dec 2022
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtraking(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backtraking(int[] coins, int idx, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = idx; i < coins.length; i++) {
            if (i != idx && coins[i] == coins[i - 1])
                continue;
            if (coins[i] <= target) {
                list.add(coins[i]);
                backtraking(coins, i + 1, target - coins[i], list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
}
