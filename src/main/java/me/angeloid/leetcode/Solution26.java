package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-01-02
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int len = nums.length;
        int i = 1;
        int k = 0;
        while (i < len) {
            if (nums[i] == pre) {
                k++;
            } else {
                if (k > 0) {
                    for (int j = i; j < len; j++) {
                        nums[j - k] = nums[j];
                    }
                    len = len - k;
                    i = i - k;
                    k = 0;

                }
                pre = nums[i];
            }
            i++;
        }
        if (k > 0) {
            len = len - k;
        }
        return len;
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        solution26.removeDuplicates(new int[]{0, 0, 0, 1, 1});
    }
}
