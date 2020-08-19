package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/1
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null)
            return -1;
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > nums[end]) {
            if (target > nums[middle] || target < nums[end]) {
                return find(nums, middle + 1, end, target);//right side.
            } else {
                return find(nums, start, middle - 1, target);//left side.
            }
        } else {
            if (target > nums[middle] && target <= nums[end]) {
                return find(nums, middle + 1, end, target);//right side.
            } else {
                return find(nums, start, middle - 1, target);//left side.
            }
        }
    }
}
