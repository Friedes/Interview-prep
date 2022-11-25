package geeksforgeeks.java.bit;

/*
 * Shreyansh and his bits : Daily 25 Nov 2022
 */
public class Solution25 {
    final int MAX = 64;
    long triangle[][] = new long[MAX + 1][MAX + 1];

    void makeTriangle() {
        triangle[0][0] = 1;
        for (int i = 1; i < MAX; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j <= i; j++)
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
    }

    long count(long n) {
        if (triangle[0][0] == 0)
            makeTriangle();
        long cnt = 0;
        int set = 0;
        for (int i = 0; i < 64; i++) {
            long oo = n & 1;
            if (oo > 0) {
                set++;
                cnt += triangle[i][set];
            }
            n = n >> 1;
        }
        return cnt;
    }
}
