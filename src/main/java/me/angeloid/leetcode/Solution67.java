package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/23
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        int i = array1.length - 1, j = array2.length - 1;
        int cf = 0;
        while (i >= 0 || j >= 0) {
            int c1 = i >= 0 ? (array1[i] - '0') : 0;
            int c2 = j >= 0 ? (array2[j] - '0') : 0;
            int sum = c1 + c2 + cf;
            cf = sum / 2;
            builder.insert(0, sum % 2);
            i--;
            j--;
        }
        if (cf != 0) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
