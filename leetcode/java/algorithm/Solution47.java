package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/*
 * Permutations II : Algorithm Day 10 > 10 Dec 2022
 */
public class Solution47 {
    Set<List<Integer>> resultSet = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, new LinkedHashMap<>());
        return new ArrayList<>(resultSet);
    }

    private void backtrack(int[] nums, LinkedHashMap<Integer, Integer> currentMap) {

        if (nums.length == currentMap.size()) {
            resultSet.add(new ArrayList<>(currentMap.values()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!currentMap.containsKey(i)) {
                currentMap.put(i, nums[i]);
                backtrack(nums, currentMap);
                currentMap.remove(i);
            }
        }
    }
}
