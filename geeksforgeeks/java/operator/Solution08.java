package geeksforgeeks.java.operator;

/*
 * Two numbers with odd occurrences
 */
public class Solution08 {
    public int[] twoOddNum(int arr[], int n) {
        // code here
        int totalXor = 0;
        for (int i = 0; i < n; ++i) {
            totalXor ^= arr[i];
        }
        int anySetBit = 0;
        for (int i = 31; i >= 0; --i) {
            int curBit = 1 << i;
            if ((totalXor & curBit) != 0) {
                anySetBit = curBit;
            }
        }
        int first = 0, second = 0;
        for (int i = 0; i < n; ++i) {
            if ((arr[i] & anySetBit) != 0) {
                second ^= arr[i];
            } else {
                first ^= arr[i];
            }
        }
        int[] ans = { first, second };
        if (first < second) {
            ans[0] = second;
            ans[1] = first;
        }
        return ans;
    }
}
