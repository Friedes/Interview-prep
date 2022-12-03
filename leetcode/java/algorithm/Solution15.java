package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 3Sum : Algorithm Day 3 > 3 Dec 2022
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        Set<List<Integer>> hashSet = new HashSet<>();
        for (int i=0;i<len-1;i++){
            int left = i+1;
            int right = len;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum<0) left++;
                if (sum>0) right--;
                if (sum == 0){
                    List<Integer> p = new ArrayList<>();
                    p.add(nums[i]);
                    p.add(nums[left]);
                    p.add(nums[right]);
                    left++;
                    right--;
                    hashSet.add(p);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
