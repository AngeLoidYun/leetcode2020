package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        Set<Integer> ySet = new HashSet<>();
        Set<Integer> xSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    ySet.add(i);
                    xSet.add(j);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (ySet.contains(i) || xSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
