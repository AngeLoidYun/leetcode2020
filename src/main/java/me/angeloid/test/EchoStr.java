package me.angeloid.test;

public class EchoStr {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            //中心字符的位置，从中心向两边扩展
            int left = i;
            int right = i;
            int right2 = i + 1;//处理偶数个情况
            while (left >= 0 && right < arr.length) {
                if (arr[left] == arr[right]) {
                    res++;
                }
                left--;
                right++;
            }
            left = i;
            while (left >= 0 && right2 < arr.length) {
                if (arr[left] == arr[right2]) {
                    res++;
                }
                left--;
                right2++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        EchoStr echoStr = new EchoStr();
        System.out.println(echoStr.countSubstrings("aaa"));
    }
}
