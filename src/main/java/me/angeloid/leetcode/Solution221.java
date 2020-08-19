package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/8
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length ==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char c = matrix[i][j];
                if (c == '0') {
                    dp[i][j] = 0;
                } else {
                    //c=='1'
                    if (j > 0 && i > 0) {
                        if (dp[i][j - 1] == dp[i - 1][j] && dp[i][j - 1] == dp[i - 1][j - 1]) {
                            dp[i][j] = dp[i][j - 1] + 1;
                        } else {
                            int v = Math.min(dp[i][j - 1], dp[i - 1][j]);
                            dp[i][j] = Math.min(v, dp[i - 1][j - 1]) + 1;
                        }
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        solution221.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }
}
