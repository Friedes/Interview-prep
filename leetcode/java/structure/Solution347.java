package leetcode.java.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Top K Frequent Elements : Data structure Day 20 > 20 Nov 2022
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int values[] = new int[map.size()];
        int x = 0;
        for (int val : map.values())
            values[x++] = val;

        Arrays.sort(values);

        int[] res = new int[k];
        x = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= values[values.length - k])
                res[x++] = e.getKey();
            if (x == k)
                break;
        }

        return res;
    }
}
