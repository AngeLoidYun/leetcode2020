package me.angeloid.leetcode;

public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
