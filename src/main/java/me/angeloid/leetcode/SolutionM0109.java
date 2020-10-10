package me.angeloid.leetcode;

public class SolutionM0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()==0&& s2.length()==0)
            return true;
        if (s1.length() != s2.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        for (; index2 < s2.length(); index2++) {
            if (s1.charAt(0) == s2.charAt(index2)) {
                //start loop
                int idx2 = index2;
                while (index1 <= s1.length()) {
                    if (index1 == s1.length()) {
                        return true;
                    }
                    if (s1.charAt(index1) != s2.charAt(idx2)) {
                        break;
                    }
                    index1++;
                    idx2 = (idx2 + 1) % s2.length();
                }
                index1 = 0;
            }
        }
        return false;
    }
}
