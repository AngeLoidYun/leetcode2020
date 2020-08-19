package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int lastHave = Integer.MIN_VALUE;
        int have = Integer.MIN_VALUE;
        int lastNoHave = 0;
        int noHave = 0;
        for (int i = 0; i < prices.length; i++) {
            have = Math.max(lastHave, lastNoHave - prices[i]);
            noHave = Math.max(lastHave + prices[i], lastNoHave);
            lastHave = have;
            lastNoHave = noHave;
        }
        return Math.max(have, noHave);
    }
}
