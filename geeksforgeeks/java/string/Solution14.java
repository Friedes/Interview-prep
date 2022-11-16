package geeksforgeeks.java.string;

/*
 * Sum of Beauty of All Substrings : Daily > 14 Nove 2022
 */
public class Solution14 {
    public static int beautySum(String s) {
        // code here
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] a = new int[26];
            for (int j = i; j < s.length(); j++) {
                a[s.charAt(j) - 'a']++;
                int max = -1;
                int min = 501;
                for (int k = 0; k < 26; k++) {
                    max = Math.max(a[k], max);
                    if (a[k] != 0)
                        min = Math.min(a[k], min);
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
