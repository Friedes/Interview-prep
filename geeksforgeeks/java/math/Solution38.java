package geeksforgeeks.java.math;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 3 Divisors > Daily : 8 Dec 2022
 */
public class Solution38 {
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        long max = 0;

        for (int i = 0; i < q; i++)
            max = Math.max(max, query.get(i));

        long nmax = (long) Math.sqrt(max);
        boolean arr[] = new boolean[(int) nmax + 1];
        Arrays.fill(arr, true);
        
        for (int i = 2; i <= nmax; i++) {
            if (arr[i]) {
                for (int j = 2; j * i <= nmax; j++) {
                    arr[j * i] = false;
                }
            }
        }

        int sum = 0;
        int ans[] = new int[arr.length];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i])
                sum++;
            ans[i] = sum;
        }

        for (int i = 0; i < query.size(); i++)
            res.add((int) ans[(int) Math.sqrt(query.get(i))]);
        
        return res;
    }
}
