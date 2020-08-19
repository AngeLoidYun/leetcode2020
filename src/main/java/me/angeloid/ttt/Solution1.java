package me.angeloid.ttt;

import java.math.BigInteger;

/**
 * @author AngeloidYun
 * @date 2020-03-11
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.hexToInt(args[0]));
    }
    public int hexToInt(String s) {
        return new BigInteger(s, 16).intValue();
    }
}
