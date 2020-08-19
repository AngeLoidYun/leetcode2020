package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class SolutionM0106 {
    public String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        char temp = 0;
        int count = 0;
        for (char c : S.toCharArray()
        ) {
            if (temp == 0) {
                temp = c;
            }
            if (temp != c) {
                builder.append(temp);
                builder.append(count);
                count = 1;
                temp = c;
            } else {
                count++;
            }
        }
        if (S.length() > 0) {
            builder.append(temp);
            builder.append(count);
        }
        return builder.length() >= S.length() ? S : builder.toString();
    }
}
