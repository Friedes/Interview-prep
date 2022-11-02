package geeksforgeeks.java.search;

import java.util.Arrays;

import geeksforgeeks.java.Solution;

/*
 * Median in a row-wise sorted Matrix : 01 Nov 2022
 */
public class Solution01 implements Solution {
    int median(int matrix[][], int R, int C) {
        // code here      
        int[] sol = new int[C*R];
        int x = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                sol[x]=matrix[i][j];
                x++;
            }
        }
        Arrays.sort(sol);
        return sol[(R*C)/2];
    }

    public String testResult(){
        return "";
    }
}
