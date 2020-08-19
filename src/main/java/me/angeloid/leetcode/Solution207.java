package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/4
 */
public class Solution207 {
    int[] visited;
    List<List<Integer>> graph;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        List<Integer> neighbor = graph.get(i);
        for (int v : neighbor) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
