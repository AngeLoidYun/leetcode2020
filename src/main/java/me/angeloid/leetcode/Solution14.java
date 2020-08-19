package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution14 {
    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        while (true) {
            char a = 0;
            for (String s : strs
            ) {
                if (index >= s.length()) {
                    return s;
                }
                if (a == 0) {
                    a = s.charAt(index);
                } else {
                    if (s.charAt(index) != a) {
                        return s.substring(0, index);
                    }
                }
            }
            index++;
        }
    }
}
