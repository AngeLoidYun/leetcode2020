package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/2
 */
public class Solution60 {
    /**
     * 排列组合求解
     *
     * 排列组合与阶乘有关。
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                factorial[i] = 1;
            } else {
                factorial[i] = factorial[i - 1] * (i);
            }
        }
        int[] used = new int[n];
        StringBuilder builder = new StringBuilder();
        k = k - 1;
        for (int i = n - 1; i >= 0; i--) {
            int itx = k / factorial[i];
            k -= itx * factorial[i];
            int ind = 0;
            for (int j = 0; j < n; j++) {
                if (used[j] == 0) {
                    ind++;
                }
                if (ind == itx + 1) {
                    builder.append(j + 1);
                    used[j] = 1;
                    break;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        solution60.getPermutation(4, 4);
    }
}
