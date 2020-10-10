package me.angeloid.leetcode;

public class SolutionLCP19 {
    public int minimumOperations(String leaves) {
        /*
        【红，黄，红】状态分别为0，1，2，dp表示要达到这个状态必须反转的叶子数量
        dp[i][j] i:index j 状态位
        1、dp[i][0] 要求前一个的状态也是0
        dp[i][0] = dp[i-1][0] +isYellow(i)//这里因为是黄色要加一次
        2、dp[i][1] 的状态要求前一个的状态可以是0也可以是1，题目求最小，因此去最小值
        dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+ isRed(i)//是红色加一次
        3、dp[i][2]的状态要求前一个的状态可以是1也可以是2
        dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2])+isYellow(i)//是黄色加一次
        */
        char[] arr = leaves.toCharArray();
        int[][] dp = new int[arr.length][3];
        dp[0][0] = arr[0] == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + (arr[i] == 'y' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (arr[i] == 'r' ? 1 : 0);
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (arr[i] == 'y' ? 1 : 0);
            }
        }
        return dp[arr.length - 1][2];
    }

    public static void main(String[] args) {
        SolutionLCP19 solutionLCP19 = new SolutionLCP19();
        System.out.println(solutionLCP19.minimumOperations("rryyyrryyrrrrr"));
    }
}
