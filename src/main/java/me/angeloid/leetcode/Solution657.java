package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/8/28
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int xOffset = 0;
        int yOffset = 0;
        for (char c : moves.toCharArray()
        ) {
            if (c == 'U') {
                yOffset++;
            } else if (c == 'D') {
                yOffset--;
            } else if (c == 'L') {
                xOffset--;
            } else if (c == 'R') {
                yOffset++;
            }
        }
        return xOffset == 0 && yOffset == 0;
    }
}
