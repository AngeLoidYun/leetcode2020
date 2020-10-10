package me.angeloid.leetcode;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v >= target) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int v2 = nums[j];
                if (v+v2==target){
                    return new int[]{i,j};
                }else if (v+v2>target){
                    return null;
                }
            }
        }
        return null;
    }
}
