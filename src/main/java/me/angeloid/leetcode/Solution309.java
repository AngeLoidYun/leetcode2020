package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/10
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[] inSoldOut = new int[n];//已卖出
        int[] inHold = new int[n];//在持有
        int[] inFreeze = new int[n];//已冷冻
        inHold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            inSoldOut[i] = Math.max(inHold[i - 1] + prices[i], inSoldOut[i - 1]);
            inHold[i] = Math.max(inFreeze[i - 1] - prices[i], inHold[i - 1]);
            inFreeze[i] = inSoldOut[i - 1];
        }
        return inSoldOut[n - 1];
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        System.out.println(solution309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
