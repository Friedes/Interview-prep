package leetcode.java.search;

/*
 * Guess Number Higher or Lower : Daily 16 Nov 2022
 */
public class Solution374 {

    public int guessNumber(int n) {
        int start = 1, end = n, mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == -1)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return mid;
    }

    /* 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int start) {
        if(start > 0)
            return -1;
        else if ( start < 0)
            return 1;
        else
            return 0;
    }

}
