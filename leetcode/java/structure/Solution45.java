package leetcode.java.structure;

/*
 * Rotate Image : Data structure Day 3 > 02 Nov 2022
 */
public class Solution45 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int row[]:matrix){
            for(int i=0;i<n/2;i++){
                int temp=row[i];
                row[i]=row[n-i-1];
                row[n-i-1]=temp;
            }
        }
    }
}
