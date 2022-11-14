package leetcode.java.structure;

/*
 * Find the Winner of the Circular Game : Data structure Day 14 > 14 Nov 2022
 */
public class Solution1823 {
    public int findTheWinner(int n, int k) {
        return circularGame(n, k) + 1;
    }

    public int circularGame(int n, int k) {
        if (n == 1)
            return 0;
        return (circularGame(n - 1, k) + k) % n;
    }
}
