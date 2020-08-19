package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/5/27
 */
public class Solution151 {
    public String reverseWords(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String[] arr = s.split(" ");
        int i = 0, j = arr.length - 1;
        while (i < j) {
            String temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < arr.length - 1; k++) {
            if (arr[k].length() != 0) {
                builder.append(arr[k].trim());
                builder.append(' ');
            }

        }
        builder.append(arr[arr.length - 1]);
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        solution151.reverseWords("  hello world!  ");
    }
}
