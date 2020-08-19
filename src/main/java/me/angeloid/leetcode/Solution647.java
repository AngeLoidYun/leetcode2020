package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/8/19
 */
public class Solution647 {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < 2 * n - 1; i++) {
            int start = i / 2;
            int end = (i + 1) / 2;

            while (start >= 0 && end <= n - 1) {
                if (s.charAt(start) == s.charAt(end)) {
                    res++;
                } else {
                    break;
                }
                start--;
                end++;
            }
        }
        return res;
    }
}
