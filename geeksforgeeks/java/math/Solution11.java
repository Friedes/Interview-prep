package geeksforgeeks.java.math;

/*
 * 
 */
public class Solution11 {
    static String isSumOfTwo(int N) {
        // code here
        for (int i = 2; i <= N; i++) {
            if (isprime(i) && isprime(N - i)) {
                return "Yes";
            }
        }
        return "No";
    }

    static boolean isprime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
