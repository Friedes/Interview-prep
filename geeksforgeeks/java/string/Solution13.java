package geeksforgeeks.java.string;

/*
 * Find patterns : Daily > 12 Nove 2022
 */
public class Solution13 {
    static int numberOfSubsequences(String s, String w) {
        // code here
        int ans = 0;
        char[] cs = s.toCharArray();
        char[] cw = w.toCharArray();
        while (true) {
            int it = 0;
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == cw[it]) {
                    cs[i] = ' ';
                    it++;
                }
                if (it == cw.length)
                    break;
            }
            if (it == cw.length)
                ans++;
            else
                break;
        }
        return ans;
    }
}
