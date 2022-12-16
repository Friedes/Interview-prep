package geeksforgeeks.java.structure;

/*
 * Articulation Point - I : Daily > 16 Dec 2022
 */
public class Solution46 {
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) {
        // code here
        int sum = 0;
        if (ty == 0) {
            if (i - 1 >= 0)
                sum += mat[i - 1][j];
            if (i + 1 < n)
                sum += mat[i + 1][j];
            if (j - 1 >= 0)
                sum += mat[i][j - 1];
            if (j + 1 < m)
                sum += mat[i][j + 1];
            if (j % 2 == 1) {
                if (i + 1 < n) {
                    if (j - 1 >= 0)
                        sum += mat[i + 1][j - 1];
                    if (j + 1 < m)
                        sum += mat[i + 1][j + 1];
                }
            } else {
                if (i - 1 >= 0) {
                    if (j - 1 >= 0)
                        sum += mat[i - 1][j - 1];
                    if (j + 1 < m)
                        sum += mat[i - 1][j + 1];
                }
            }
            return sum;
        } else {
            if (i - 2 >= 0)
                sum += mat[i - 2][j];
            if (i + 2 < n)
                sum += mat[i + 2][j];
            if (j - 2 >= 0)
                sum += mat[i][j - 2];
            if (j + 2 < m)
                sum += mat[i][j + 2];
            if (i - 1 >= 0) {
                if (j - 2 >= 0)
                    sum += mat[i - 1][j - 2];
                if (j + 2 < m)
                    sum += mat[i - 1][j + 2];
            }
            if (i + 1 < n) {
                if (j - 2 >= 0)
                    sum += mat[i + 1][j - 2];
                if (j + 2 < m)
                    sum += mat[i + 1][j + 2];
            }
            if (j % 2 == 1) {
                if (i - 1 >= 0) {
                    if (j - 1 >= 0)
                        sum += mat[i - 1][j - 1];
                    if (j + 1 < m)
                        sum += mat[i - 1][j + 1];
                }
                if (i + 2 < n) {
                    if (j - 1 >= 0)
                        sum += mat[i + 2][j - 1];
                    if (j + 1 < m)
                        sum += mat[i + 2][j + 1];
                }
            } else {
                if (i + 1 < n) {
                    if (j - 1 >= 0)
                        sum += mat[i + 1][j - 1];
                    if (j + 1 < m)
                        sum += mat[i + 1][j + 1];
                }
                if (i - 2 >= 0) {
                    if (j - 1 >= 0)
                        sum += mat[i - 2][j - 1];
                    if (j + 1 < m)
                        sum += mat[i - 2][j + 1];
                }
            }
            return sum;
        }
    }
}