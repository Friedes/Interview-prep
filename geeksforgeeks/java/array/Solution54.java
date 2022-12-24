package geeksforgeeks.java.array;

/*
 * Wine Buying and Selling : 24 Dec 2022
 */
public class Solution54 {
    long wineSelling(int Arr[], int N) {
        // code here
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.abs(sum);
            sum += Arr[i];
        }
        return ans;
    }
}
