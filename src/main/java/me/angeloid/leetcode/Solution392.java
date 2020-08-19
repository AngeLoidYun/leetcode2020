package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/31
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] arr = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            arr[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (j == t.charAt(i) - 'a') {
                    arr[i][j] = i;
                } else {
                    arr[i][j] = arr[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - 'a';
            if (arr[add][v] == m) {
                return false;
            }
            add = arr[add][v] + 1;
        }
        return true;
    }
}
