package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-02
 */
public class Solution53 {
    /**
     * 解法1，暴力法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxValue = Math.max(maxValue, sum);
            }
        }
        return maxValue;
    }


    /**
     * 解法2，动态规划法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxValue = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v = Math.max(pre + nums[i], nums[i]);
            maxValue = Math.max(maxValue, v);
            pre = nums[i];
        }
        return maxValue;
    }
}
