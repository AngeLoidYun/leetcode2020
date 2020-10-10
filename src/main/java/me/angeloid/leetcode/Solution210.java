package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> edges = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            edges.get(edge[1]).add(edge[0]);
            inDegree[edge[0]] += 1;
        }
        int i = 0;
        boolean[] visited = new boolean[numCourses];
        int[] res = new int[numCourses];
        OUT:
        while (i < numCourses) {
            for (int j = 0; j < numCourses; j++) {
                if (inDegree[j] == 0 && !visited[j]) {
                    //
                    visited[j] = true;
                    edges.get(j).forEach(integer -> inDegree[integer] -= 1);
                    res[i] = j;
                    i++;
                    continue OUT;
                }
            }
            return new int[]{};
        }
        return res;
    }
}
