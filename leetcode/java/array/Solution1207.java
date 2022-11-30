package leetcode.java.array;

/*
 * Unique Number of Occurrences : Daily > 30 Nov 2022
 */
public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int map[] = new int[2001];
        for (int val : arr)
            map[val + 1000]++;
        boolean set[] = new boolean[arr.length + 1];
        for (int val : map)
            if (set[val] && val != 0)
                return false;
            else
                set[val] = true;
        return true;
    }
}
