package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int cf = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int v1 = A[i];
            int v2 = K % 10;
            K = K / 10;
            int v3 = (v1 + v2 + cf) % 10;
            cf = (v1 + v2 + cf) / 10;
            list.add(0, v3);
        }
        while (K != 0) {
            int v2 = K % 10;
            K = K / 10;
            int v = (v2 + cf) % 10;
            list.add(0, v);
            cf = (v2 + cf) / 10;
        }
        if (cf != 0) {
            list.add(0, cf);
        }
        return list;
    }
}
