package leetcode.java.algorithm;

/*
 * Search a 2D Matrix : Algorithm Day 1 > 1 Dec 2022
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int midElement = matrix[mid / cols][mid % cols];
            if (midElement == target)
                return true;
            else if (midElement < target)
                left = mid + 1;
            else if (midElement > target)
                right = mid - 1;
        }
        return false;
    }
}
