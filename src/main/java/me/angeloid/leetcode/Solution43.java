package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020/5/27
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[len1 + len2];
        Arrays.fill(res, '0');
        for (int i = len1 - 1; i >= 0; i--) {
            int cf = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int total = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[i + j + 1] + cf + total % 10 - '0';
                res[i + j + 1] = sum % 10 + '0';
                cf = sum / 10+total/10;//这里的进位标志，既要计算该位乘起来后的进位，也要计算加上res中原有的值后产生的进位
            }
            res[i] += cf;
        }
        StringBuilder builder = new StringBuilder();
        boolean canInsert = false;
        for (int v : res
        ) {
            if (v != '0') {
                canInsert = true;
            }
            if (canInsert) {
                builder.append(v - '0');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.multiply("122", "20"));
    }
}
