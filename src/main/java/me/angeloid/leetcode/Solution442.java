package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v != -1) {
                nums[i] = -1;//avoid cycle.
                deal(nums, list, v);
            }
        }
        return list;
    }

    private void deal(int[] nums, List<Integer> list, int i) {
        if (i <= 0) {
            return;
        }
        int v = nums[i - 1];
        //compare i with v.
        if (i == v) {
            list.add(i);
        } else {
            nums[i - 1] = i;
            deal(nums, list, v);
        }
    }

    public static void main(String[] args) {
        Solution442 solution442 = new Solution442();
        System.out.println(solution442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
