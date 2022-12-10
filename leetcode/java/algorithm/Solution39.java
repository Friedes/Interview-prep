package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * Combination Sum : Algorithm Day 10 > 10 Dec 2022
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(candidates, 0 , target, new ArrayList<Integer>() , result);
        return result;
    }
    
    private void backtrack(int[] cand , int start , int target, List<Integer> list , List<List<Integer>> result){
        if(target < 0)
            return;
        if(target == 0)
            result.add(new ArrayList<Integer>(list));
        for(int i = start ; i < cand.length ; i++){
            list.add(cand[i]);
            backtrack(cand , i , target - cand[i] , list , result);
            list.remove(list.size() - 1);
        }
    }
}
