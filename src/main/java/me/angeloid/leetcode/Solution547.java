package me.angeloid.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020/6/2
 */
public class Solution547 {
    /**
     * 并查集解法
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] father = new int[len];
        for (int i = 0; i < len; i++) {
            father[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    if (father[i] != father[j]) {
                        int ready = father[i];
                        father[i] = father[j];
                        for (int k = 0; k < len; k++) {
                            if (father[k] == ready) {
                                father[k] = father[j];
                            }
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(father[i]);
        }
        return set.size();
    }


    public int findCircleNum2(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }


    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
        solution547.findCircleNum2(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
    }

}
