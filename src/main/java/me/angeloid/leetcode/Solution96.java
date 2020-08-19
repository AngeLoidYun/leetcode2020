package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/7/15
 */
public class Solution96 {
    int res = 1;

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int sum = 0;
            int ma = i - 1;
            int j = 0;
            while (j <= ma) {
                int tmpSum = dp[j] * dp[ma];
                if (j == ma) {
                    sum += tmpSum;
                } else {
                    sum += 2 * tmpSum;
                }
                j++;
                ma--;
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    private void buildTrees(int n) {

    }
}
