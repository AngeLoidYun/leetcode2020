package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            table.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int[] edge = edges[i];
            int v1 = edge[0];
            int v2 = edge[1];
            table.get(v1 - 1).add(v2);
            table.get(v2 - 1).add(v1);
        }
        int[] visited = new int[N];
        int last = edges[0][0];
        visited[last - 1] = 1;
        int[] res = new int[2];
        OUT:
        for (; ; ) {
            List<Integer> list = table.get(last - 1);
            for (int v : list
            ) {
                if (v == last) {
                    //pass
                } else if (visited[v - 1] == 0) {
                    visited[v - 1] = 1;
                    last = v;
                    break;
                } else {
                    res[0] = v;
                    res[1] = last;
                    break OUT;
                }
            }

        }
        return res;
    }
}
