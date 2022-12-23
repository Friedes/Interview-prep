package leetcode.java.array;

/*
 * Best Time to Buy and Sell Stock with Cooldown : Daily > 23 Dec 2022
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int dpHold = Integer.MIN_VALUE;
        int dpSold = 0;
        int dpCoolDownOrRest = 0;
        for (int i = 0; i < prices.length; i++) {
            int preDpHold = dpHold;
            int preDpSold = dpSold;
            int preDpCooldownOrRest = dpCoolDownOrRest;
            dpHold = Math.max(preDpHold, preDpCooldownOrRest - prices[i]);
            dpSold = preDpHold + prices[i];
            dpCoolDownOrRest = Math.max(preDpCooldownOrRest, preDpSold);
        }
        return Math.max(dpSold, dpCoolDownOrRest);
    }
}