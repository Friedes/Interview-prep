package geeksforgeeks.java.array;

import java.util.Vector;

/*
 * Complement : 14 Dec 2022
 */
public class Solution44 {
    Vector<Integer> findRange(String str, int n) {
        // code here
        int l = -1;
        int max = 0;
        int count = 0;
        int maxL = -1;
        int maxR = -1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    l = -1;
                    count = 0;
                }
            }
            if (count == 1 && l == -1)
                l = i;
            if (count > max) {
                max = count;
                maxL = l + 1;
                maxR = i + 1;
            }
        }
        Vector<Integer> ans = new Vector<Integer>();
        ans.add(maxL);
        if (maxL != -1)
            ans.add(maxR);
        return ans;
    }
}
