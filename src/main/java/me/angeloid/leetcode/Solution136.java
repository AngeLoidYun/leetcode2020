package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020-01-08
 */
public class Solution136 {
    /**
     * 方案1、 哈希表法
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int v : nums
        ) {
            if (set.contains(v)) {
                set.remove(v);
            } else {
                set.add(v);
            }
        }
        return new ArrayList<Integer>(set).get(0);
    }

    /**
     * 方案2、数学法异或
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
}
