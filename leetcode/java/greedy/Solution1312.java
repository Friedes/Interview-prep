package leetcode.java.greedy;


/*
 * Maximum 69 Number : Daily 07 Nov 2022
 */
public class Solution1312 {
    public int maximum69Number (int num) {
        int n_digits = (int) Math.log10(num) + 1;
        int ans = num;
        while( n_digits>0 ) {
            int temp = num / (int) Math.pow(10, n_digits-1);
            if( temp == 6 ) {
                ans = ans + 3 * (int) Math.pow(10, n_digits-1);
                return ans;
            }
            num = num - 9 * (int) Math.pow(10, n_digits-1);
            n_digits--;
        }
        return ans;
    }
}
