package geeksforgeeks.java.array;

import java.util.Arrays;

public class Solution03 {
    int removals(int[] arr, int n, int k) {
         Arrays.sort(arr);
 
         int i=0, j=0, maxRange = 0;
        
         while(j<n){
             if(arr[j]-arr[i] <= k) j++;
             else if(i < j) i++;
             maxRange = Math.max(maxRange, j - i);
         }
 
         return n-maxRange;
     }
}
