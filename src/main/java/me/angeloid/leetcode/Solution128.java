package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.*;
import java.util.function.Function;

/**
 * @author AngeloidYun
 * @date 2020/6/1
 */
public class Solution128 {


    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int v : nums) {
            if (map.get(v) == null) {
                int value = map.getOrDefault(v - 1, 0) + map.getOrDefault(v + 1, 0) + 1;
                map.put(v, value);
                map.put(v + map.getOrDefault(v + 1, 0), value);
                map.put(v - map.getOrDefault(v - 1, 0), value);
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums==null|| nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int curLength = 1;
        int longestLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    curLength++;
                } else {
                    longestLength = Math.max(longestLength, curLength);
                    curLength = 1;
                }
            }
        }
        return Math.max(longestLength, curLength);
    }


    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        solution128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

}
