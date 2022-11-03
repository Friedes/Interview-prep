package leetcode.java.structure;

/*
 * Spiral Matrix II : Data structure Day 3 > 02 Nov 2022
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int rowEnd = n - 1, colEnd = n - 1, m1 = 0, n1 = 0, k = 1;
        while (m1 <= rowEnd && n1 <= colEnd) {
            for (int i = n1; i <= colEnd; i++) {
                mat[m1][i] = k++;
            }
            m1++;

            for (int i = m1; i <= rowEnd; i++) {
                mat[i][colEnd] = k++;
            }
            colEnd--;

            for (int i = colEnd; i >= n1; i--) {
                mat[rowEnd][i] = k++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= m1; i--) {
                mat[i][n1] = k;
                k = k + 1;
            }
            n1++;
        }
        return mat;
    }
}
