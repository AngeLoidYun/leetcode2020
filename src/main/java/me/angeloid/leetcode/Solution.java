package me.angeloid.leetcode;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] arr = new boolean[52];
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c - 'a'] = true;
            } else {
                arr[c - 'A' + 26] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                res += arr[c - 'a'] ? 1 : 0;
            } else {
                res += arr[c - 'A' + 26] ? 1 : 0;
            }
        }
        return res;
    }
}
