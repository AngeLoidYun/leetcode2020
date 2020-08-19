package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/9
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0) {
                res = Math.max(prices[i] - min, res);
            }
            min = Math.min(min, prices[i]);
        }
        return res;
    }


    /**
     * 122题
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int lastHold = 0;//上次持有股票
        int lastNonHold = 0;//上次未持有股票
        int curHold = 0;
        int curNonHold = 0;
        for (int i = 0; i < prices.length; i++) {
            int v = prices[i];
            curNonHold = Math.max(lastHold + v, lastNonHold);
            curHold = Math.max(lastNonHold - v, lastHold);
            lastHold = curHold;
            lastNonHold = curNonHold;
        }
        return Math.max(lastHold, lastNonHold);
    }
}
