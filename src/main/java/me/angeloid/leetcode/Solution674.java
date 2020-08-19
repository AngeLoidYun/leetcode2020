package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/1
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null||nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int curStart = 0;
        int res = 0;
        int curValue = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] <= curValue) {
                res = Math.max(res, i - curStart);
                curStart = i;
            }
            curValue = nums[i];
        }
        res = Math.max(res, len - curStart);
        return res;
    }
}
