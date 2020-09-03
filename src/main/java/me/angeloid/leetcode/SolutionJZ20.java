package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/9/2
 */
public class SolutionJZ20 {
    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();
        if (s.contains("e")) {
            String[] split = s.split("e");
            if (split.length !=2) {
                return false;
            }
        }
        if (s.contains(".")) {
            String[] split = s.split("\\.");
            if (split.length !=2) {
                return false;
            }
        }
        char c0 = s.charAt(0);
        if (c0 == '+' || c0 == '-' || (c0 >= '0' && c0 <= '9')) {
            //可以
        } else {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || c == 'e' || c == '.'||c==' ') {

            } else {
                return false;
            }
        }
        return true;
    }
}
