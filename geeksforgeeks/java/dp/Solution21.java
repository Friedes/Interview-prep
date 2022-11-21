package geeksforgeeks.java.dp;

import java.util.ArrayList;

/*
 * Unique partitions : 21 Nov 2022
 */
public class Solution21 {
    void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> t, int ind, int s, int[] a) {
        if (ind < 0 || s < 0)
            return;
        t.add(a[ind]);
        if (s - a[ind] == 0)
            ans.add(new ArrayList<>(t));
        solve(ans, t, ind, s - a[ind], a);
        t.remove(t.size() - 1);
        solve(ans, t, ind - 1, s, a);
    }

    public ArrayList<ArrayList<Integer>> UniquePartitions(int n) {
        // Code here
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i + 1;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        solve(ans, t, n - 1, n, a);
        return ans;
    }
}
