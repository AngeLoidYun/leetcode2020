package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/17
 */
public class Solution35 {
    /**
     * 顺序勘测法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    /**
     * 二分查找法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int i, int j, int target) {
        if (i > j) {
            return i;
        }
        int m = (i + j) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            if (i == j) {
                return j+1;
            }
            return search(nums, m + 1, j, target);
        } else {
            if (i == j) {
                return i;
            }
            return search(nums, i, m - 1, target);
        }
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        solution35.searchInsert2(new int[]{1, 3, 5, 6}, 2);
    }


}
