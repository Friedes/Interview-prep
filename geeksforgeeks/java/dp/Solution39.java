package geeksforgeeks.java.dp;

/*
 * Black and White : Daily 09 Dec 2022
 */
public class Solution39 {
    static long numOfWays(int N, int M) {
        // add your code here
        long count = 0;
        int[] moves1 = { -2, -2, 2, 2, 1, -1, 1, -1 };
        int[] moves2 = { -1, 1, -1, 1, -2, -2, 2, 2 };

        int allMoves = N * M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count += allMoves - ways(moves1, moves2, N, M, i, j) - 1;
                count = count % 1000000007;
            }
        }

        return count;
    }

    static long ways(int[] moves1, int[] moves2, int N, int M, int r, int c) {
        long count = 0;

        for (int i = 0; i < 8; i++) {
            if (isSafe(N, M, r + moves1[i], c + moves2[i])) {
                count++;
            }
        }

        return count;
    }

    static boolean isSafe(int N, int M, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
