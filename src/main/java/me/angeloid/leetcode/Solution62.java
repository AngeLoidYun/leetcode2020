package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020-01-02
 */
public class Solution62 {
    /**
     * 解法1,动态规划法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 解法2，压缩的动态规划算法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int less = Math.min(m, n);
        int more = Math.max(m, n);

        int[] dp = new int[less];
        // 空间压缩，就是利用了dp暂存了上一轮的值，在这一次的赋值中循环利用
        // 默认第一行或者第一列的值都是1，因为第一行的路径只能从左侧走过来
        Arrays.fill(dp, 1);

        for (int i = 1; i < more; i++) {
            for (int j = 1; j < less; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[less - 1];
    }
}
