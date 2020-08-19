package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020/7/16
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        System.out.println(Arrays.deepToString(graph));
        int n = graph.length;
        int[] partial = new int[n];
        Arrays.fill(partial, -1);
        for (int i = 0; i < n; i++) {
            int m = graph[i].length;
            int teamA = partial[i];
            int teamB = -1;
            for (int j = 0; j < m; j++) {
                int readyTeamB = partial[graph[i][j]];
                if (readyTeamB == -1) {
                    readyTeamB = teamB;
                }
                if (teamB != -1 && (readyTeamB != teamB || readyTeamB == teamA)) {
                    return false;
                }
                teamB = readyTeamB;
            }
            int flagA = 1, flagB = 2;
            if (teamA == 2||teamB ==1) {
                flagA = 2;
                flagB = 1;
            }
            partial[i] = flagA;
            for (int j = 0; j < m; j++) {
                partial[graph[i][j]] = flagB;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution785 solution785 = new Solution785();
        System.out.println(solution785.isBipartite(new int[][]{{3}, {2,4}, {1}, {0,4},{1,3}}));
    }
}
