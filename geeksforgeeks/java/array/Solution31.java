package geeksforgeeks.java.array;

/*
 * Maximum Sub Array : 1 Dec 2022
 */
public class Solution31 {
    // temp: input array
    // n: size of array
    // Function to rearrange the array elements alternately.
    public static void rearrange(long arr[], int n) {
        // Your code here
        int i = 0, j = n - 1;
        long ans[] = new long[n];
        int size = 0;
        while (i < j) {
            ans[size++] = arr[j];
            ans[size++] = arr[i];
            i++;
            j--;
        }
        if (n % 2 == 1)
            ans[n - 1] = arr[n / 2];
        for (int k = 0; k < n; k++)
            arr[k] = ans[k];
    }
}
