package geeksforgeeks.java.string;

/*
 * Check if it is possible to convert one string into another with given constraints : Daily > 2 Dec 2022
 */
public class Solution32 {
    int isItPossible(String S, String T, int M, int N) {
        // code here
        S = S.replace("#", "");
        T = T.replace("#", "");

        if (S.length() != T.length())
            return 0;
        else {
            if (!S.equals(T))
                return 0;
        }
        return 1;
    }
}
