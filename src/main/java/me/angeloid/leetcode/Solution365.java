package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class Solution365 {
    /**
     * 水壶问题，实际为求x,y的最大公约数能否被z整除
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x == 0 && y == 0) {
            return false;
        }
        if (z > x + y) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z % (x | y) == 0;
        }
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        while (y % x != 0) {
            int v = y % x;
            y = x;
            x = v;
        }
        return z % x == 0;
    }
}
