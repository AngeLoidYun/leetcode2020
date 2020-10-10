package me.angeloid.leetcode;

public class Solution983 {
    /**
     * 从后向前
     * 如果这天不需要出行
     * 那么dp[i] =dp[i+1]
     * 如果这天需要出行
     * 那么dp[i] = min{cost[j]+dp[i+j]}
     * dp[1]就是结果
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int ptr = 0;
        int i = 1;
        for (; i < 366; i++) {
            if (ptr >= days.length) {
                break;
            }
            if (i != days[ptr]) {
                dp[i] = dp[i - 1];
            } else {
                ptr++;
                int v1 = costs[0] + dp[i - 1];
                int v2;
                if (i - 7 <= 0) {
                    v2 = costs[1] + dp[0];
                } else {
                    v2 = costs[1] + dp[i - 7];
                }
                int v3;
                if (i - 30 <= 0) {
                    v3 = costs[2] + dp[0];
                } else {
                    v3 = costs[2] + dp[i - 30];
                }
                dp[i] = Math.min(Math.min(v1, v2), v3);
            }
        }
        return dp[i - 1];
    }
}
