package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/8/4
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int ptr = 0;
        int cf = 0;
        StringBuilder builder = new StringBuilder();
        while (ptr < Math.max(m, n)) {
            int a = m - 1 - ptr;
            int b = n - 1 - ptr;
            int n1 = a >= 0 ? num1.charAt(a) - '0' : 0;
            int n2 = b >= 0 ? num2.charAt(b) - '0' : 0;
            int sum = (n1 + n2 + cf) % 10;
            cf = (n1 + n2 + cf) / 10;
            builder.insert(0, sum);
            ptr++;

        }
        if (cf > 0) {
            builder.insert(0,cf);
        }

        try{

        }finally {

        }
        return builder.toString();


    }

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        System.out.println(solution415.addStrings("22368", "7117657"));
    }
}
