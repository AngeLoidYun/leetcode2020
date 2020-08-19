package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/6
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n;
        if (m == 0 || (n = obstacleGrid[0].length) == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j - 1];
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }

            }

        }
        return dp[m - 1][n - 1];
    }


}
