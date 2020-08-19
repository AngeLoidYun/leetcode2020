package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution238 {
    /**
     * 左积右积法
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * k;
            k = k * nums[i];
        }
        return res;
    }
}
