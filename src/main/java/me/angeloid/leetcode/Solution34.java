package me.angeloid.leetcode;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length ==0){
            return new int[]{-1,-1};
        }
        int first = findFirst(nums, 0, nums.length - 1, target);
        int last = findLast(nums, 0, nums.length - 1, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] >= target) {
            return findFirst(nums, start, mid, target);
        } else {
            return findFirst(nums, mid + 1, end, target);
        }
    }

    private int findLast(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start+1) / 2;
        if (nums[mid] > target) {
            return findLast(nums, start, mid-1, target);
        } else {
            return findLast(nums, mid, end, target);
        }
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        solution34.searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
