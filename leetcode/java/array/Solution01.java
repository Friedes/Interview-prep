package leetcode.java.array;

import leetcode.java.Solution;

/*
 * Problem 01 : two sum
 */
public class Solution01 implements Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    public String testResult(){
        int[] test = {1,2,3};
        return String.valueOf(this.twoSum(test,1)[0]);
    }
}