package me.angeloid.leetcode;

import me.angeloid.test.Solution;

/**
 * @author AngeloidYun
 * @date 2020/8/24
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char pointed = s.charAt(i);
            if (first == pointed) {
                if (s.length() % i != 0) {
                } else {
                    if (checkChild(s, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkChild(String s, int i) {
        int mul = s.length() / i;
        for (int j = 0; j < mul; j++) {
            for (int k = 0; k < i; k++) {
                char pre = s.charAt(k);
                char selected = s.charAt(j * i + k);
                if (pre != selected) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution459 solution459 = new Solution459();
        solution459.repeatedSubstringPattern("abab");
    }
}
