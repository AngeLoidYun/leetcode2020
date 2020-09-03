package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/25
 */
public class Solution491 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        //先找开头
        int ptr1 = 0;
        int ptr2 = 0;
        return null;
    }

    private void find(int[] nums, int i, List<Integer> list) {
        for (int j = i; j < nums.length; j++) {
            if (nums[j] >= nums[j - 1]) {
                List<Integer> add = new ArrayList<>(list);
                add.add(nums[j]);
                res.add(add);
                find(nums, j + 1, add);
            }
        }
    }



    public static void main(String[] args) {
        Solution491 solution491 = new Solution491();
        System.out.println(solution491.findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(solution491.getClass().getClassLoader().toString());
        System.out.println(solution491.getClass().getClassLoader().getParent().toString());
        System.out.println(solution491.getClass().getClassLoader().getParent().getParent().toString());
    }
}
