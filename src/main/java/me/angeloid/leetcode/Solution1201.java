package me.angeloid.leetcode;

import me.angeloid.test.Solution;

public class Solution1201 {


    public int nthUglyNumber(int n, int a, int b, int c) {
        long curV = 0;
        for (int i = 0; i < n; i++) {
            long v1 = ((curV / a) + 1) * a;
            long v2 = ((curV / b) + 1) * b;
            long v3 = ((curV / c) + 1) * c;
            curV = Math.min(Math.min(v1, v2), v3);
        }
        return (int) curV;
    }

    public static void main(String[] args) {

        Solution1201 solution1201 = new Solution1201();
        System.out.println(solution1201.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
