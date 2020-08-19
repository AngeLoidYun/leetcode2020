package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/2
 */
public class Solution42 {
    public int trap(int[] height) {
        int[][] lowHigh = new int[height.length][2];
        int max = 0;
        for (int i = 0; i < height.length; i++) {//from left to right.
            lowHigh[i][0] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;//reset max.
        for (int i = height.length - 1; i >= 0; i--) {
            lowHigh[i][1] = max;
            max = Math.max(max, height[i]);
        }
        int[] hi = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            hi[i] = Math.min(lowHigh[i][0], lowHigh[i][1]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int each = hi[i] - height[i];
            if (each > 0) {
                res += each;
            }
        }
        return res;
    }


    public int trap2(int[] height) {
        int[][] lowHigh = new int[height.length][2];
        int max = 0;
        for (int i = 0; i < height.length; i++) {//from left to right.
            lowHigh[i][0] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;//reset max.
        for (int i = height.length - 1; i >= 0; i--) {
            lowHigh[i][1] = max;
            max = Math.max(max, height[i]);
        }
        int[] hi = new int[height.length];
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            hi[i] = Math.min(lowHigh[i][0], lowHigh[i][1]);
            int each = hi[i] - height[i];
            if (each > 0) {
                res += each;
            }
        }
        return res;
    }


    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                //we can trust the left max .
                result += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
}