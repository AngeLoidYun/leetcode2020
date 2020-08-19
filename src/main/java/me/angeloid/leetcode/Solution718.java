package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/1
 */
public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int len = Math.min(A.length - i, B.length);
            int max = findMax(A, B, i, 0, len);
            res = Math.max(res, max);
        }
        for (int i = 0; i < B.length; i++) {
            int len = Math.min(A.length, B.length - i);
            int max = findMax(A, B, 0, i, len);
            res = Math.max(res, max);
        }
        return res;
    }

    private int findMax(int[] A, int[] B, int offA, int offB, int len) {
        int max = 0;
        int t = 0;
        for (int i = 0; i < len; i++) {
            if (A[offA + i] == B[offB + i]) {
                t++;
            } else {
                max = Math.max(max, t);
                t = 0;
            }
        }
        return Math.max(max, t);
    }

    public static void main(String[] args) {

        Solution718 solution718 = new Solution718();
        solution718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }
}
