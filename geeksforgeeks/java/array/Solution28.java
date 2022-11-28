package geeksforgeeks.java.array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Maximum Sub Array : 28 Nov 2022
 */
public class Solution28 {
    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        long sum = 0;
        int l = 0, idx = -1;

        long max = 0;
        int l1 = 0, idx1 = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                sum += (long) (a[i]);
                l++;
                if (idx == -1) {
                    idx = i;
                }
            } else {
                sum = 0;
                l = 0;
                idx = -1;
            }
            if (max < sum) {
                max = sum;
                idx1 = idx;
                l1 = l;
            } else if (max == sum) {
                if (l1 < l) {
                    max = sum;
                    idx1 = idx;
                    l1 = l;
                }
            }
        }

        if (l1 == 0)
            return new ArrayList<>(Arrays.asList(-1));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = idx1; i < n && a[i] >= 0; i++)
            list.add(a[i]);
        return list;
    }
}
