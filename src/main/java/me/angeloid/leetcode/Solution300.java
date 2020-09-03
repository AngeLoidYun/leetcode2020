package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/9/2
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxL = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[maxL] < nums[i]) {
                dp[++maxL] = nums[i];
            } else {
                //二分法查找
                int j = 0;
                int k = maxL;
                while (j < k) {
                    int mid = (j + k) / 2;
                    if (dp[mid] < nums[i]) {
                        j = mid + 1;
                    } else {
                        k = mid - 1;
                    }
                }
                if (dp[j]>nums[i]){
                    dp[j] = nums[i];
                }
            }
        }
        return maxL;
    }
}
