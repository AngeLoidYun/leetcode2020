package me.angeloid.leetcode;

import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/31
 */
public class Solution841 {
    boolean complete = false;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited, visited.length);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited, int total) {
        if (visited[i]) {
            return;
        }
        if (total == 0 || complete) {
            complete = true;
            return;
        }
        total -= 1;
        visited[i] = true;

        List<Integer> list = rooms.get(i);
        for (int v : list
        ) {
            dfs(rooms, v, visited, total);
        }
    }

    public static void main(String[] args) {
        Solution841 solution841 = new Solution841();
        System.out.println(solution841.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0,2))));
    }
}
