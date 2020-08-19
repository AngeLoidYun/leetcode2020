package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/17
 */
public class Solution1014 {

    public int maxScoreSightseeingPair(int[] A)
    {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                res = Math.max(res, A[i] + A[j] + i - j);
            }
        }
        return res;
    }
    public int maxScoreSightseeingPair2(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int i = 0;
        int j = A.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, A[i] + A[j] + i - j);
            if ((A[i + 1] - A[i]) > (A[j - 1] - A[j]) && j - i > 1) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
