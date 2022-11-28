package leetcode.java.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Find Players With Zero or One Losses : Daily > 28 Nov 2022
 */
public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int[] arr = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            if (arr[matches[i][0]] >= 0)
                arr[matches[i][0]]++;
            if (arr[matches[i][1]] >= 0)
                arr[matches[i][1]] = -1;
            else
                arr[matches[i][1]] = -2;
        }

        List<Integer> winners = new ArrayList<Integer>();
        List<Integer> onelosers = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                winners.add(i);
            else if (arr[i] == -1)
                onelosers.add(i);
        }

        ll.add(winners);
        ll.add(onelosers);

        return ll;
    }
}
