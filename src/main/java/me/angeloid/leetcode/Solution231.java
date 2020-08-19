package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n >= 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
