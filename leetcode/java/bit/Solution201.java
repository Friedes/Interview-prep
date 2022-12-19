package leetcode.java.bit;

/*
 * Bitwise AND of Numbers Range : Daily 19 Dec 2022
 */
public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int c = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            c++;
        }
        return left << c;
    }
}
