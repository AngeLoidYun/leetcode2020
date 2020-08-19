package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution292 {

    /**
     * 数学法
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * 动态规划法,超时了
     *
     * @param n
     * @return
     */
    public boolean canWinNim2(int n) {
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        if (n >= 4) {
            for (int i = 3; i < n; i++) {
                if (i == 3) {
                    dp[i] = false;
                } else {
                    dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
                }
            }
            return dp[n - 1];
        } else {
            return dp[n - 1];
        }
    }
}
