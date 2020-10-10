package me.angeloid.test;

public class FindStr {


    /**
     * 状态转移方程
     * <p>
     * s1[0]=0 s2[0]=0  dp[i][j] = 0;
     * s1[i]==s2[j] dp[i][j] = dp[i-1][j-1]+1;
     * s1[i]!=s2[j] dp[i][j] = 0;
     */
    public String publicStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[][] dp = new int[m][n];
        int endPosition = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endPosition = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s2.substring(endPosition - maxLength + 1, endPosition + 1);
    }

    public static void main(String[] args) {
        FindStr findStr = new FindStr();
        System.out.println(findStr.publicStr("123abc", "3a"));
    }
}
