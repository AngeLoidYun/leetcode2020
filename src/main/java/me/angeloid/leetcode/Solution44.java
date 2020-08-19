package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/5
 */
public class Solution44 {
    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n+1; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                char a = s.charAt(i-1);
                char b = p.charAt(j-1);
                if (a == b || b == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (b == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }


}
