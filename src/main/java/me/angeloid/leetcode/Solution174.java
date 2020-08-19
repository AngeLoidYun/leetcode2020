package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020/7/13
 */
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][][] dp = new int[m][n][2];
        //0位置表示当前的路径中最大的数值（）多条路径中点数最大的那一条
        //1位置表示目前遇到的最低初始健康
        //1位置的状态转移方程为:
        //dp[i][j][1]=max(dp[i][j-1][0],dp[i-1][j][0])+当前格子正数？0:dungeon[i][j],
        //翻译过来就是，当前位置需要的最低初始健康是,
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //路径
                if (i == 0 && j == 0) {
                    dp[i][j][0] = dungeon[i][j];
                } else {
                    int left = i > 0 ? dp[i - 1][j][0] : Integer.MIN_VALUE;
                    int top = j > 0 ? dp[i][j - 1][0] : Integer.MIN_VALUE;
                    dp[i][j][0] = Math.max(top, left) + dungeon[i][j];
                }

                //最小健康
                if (i == 0 && j == 0) {
                    dp[i][j][1] = Math.min(dungeon[i][j], 0);
                } else {
                    int mTop = i > 0 ? dp[i - 1][j][1] : Integer.MIN_VALUE;
                    int mLeft = j > 0 ? dp[i][j - 1][1] : Integer.MIN_VALUE;
                    int maxV = Math.max(mTop, mLeft);
                    int left = i > 0 ? dp[i - 1][j][1] : Integer.MAX_VALUE;
                    int right = j > 0 ? dp[i][j - 1][0] : Integer.MAX_VALUE;
                    int minP = Math.min(left, right);
                    int res = Math.max(minP + dungeon[i][j], maxV);
                    dp[i][j][1] = res;
                }
            }
        }return dp[m - 1][n - 1][1] >= 0 ? 1 : Math.abs(dp[m - 1][n - 1][1]) + 1;
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        Solution174 solution174 = new Solution174();
//        System.out.println(solution174.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(solution174.calculateMinimumHP(new int[][]{{0, 5}, {-2, -3}}));
    }

}
