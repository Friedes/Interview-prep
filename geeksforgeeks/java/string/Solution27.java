package geeksforgeeks.java.string;

/*
 * Add Binary Strings : Daily > 27 Nove 2022
 */
public class Solution27 {
    String addBinary(String A, String B) {
        // code here
        int n = A.length();
        int m = B.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();
        int i = n - 1, j = m - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0 && A.charAt(i) == '1')
                sum++;
            if (j >= 0 && B.charAt(j) == '1')
                sum++;
            sum += carry;
            char bit = '0';
            if (sum > 1)
                carry = 1;
            else
                carry = 0;
            if (sum == 3 || sum == 1)
                bit = '1';
            res.append(bit);
            i--;
            j--;
        }
        if (carry == 1)
            res.append('1');
        res.reverse();
        i = 0;
        int res_len = res.length();
        while (i < res_len - 1) {
            if (res.charAt(i) == '1')
                break;
            i++;
        }
        return res.substring(i, res_len);
    }
}
