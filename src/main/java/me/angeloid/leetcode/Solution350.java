package me.angeloid.leetcode;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author AngeloidYun
 * @date 2020/7/13
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] resA = new int[res.size()];
        for (int k = 0; k < resA.length; k++) {
            resA[k] = res.get(k);
        }
        return resA;
    }


    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.compute(nums1[i], new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    if (integer2 == null) {
                        integer2 = 0;
                    }
                    return ++integer2;
                }
            });
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            Integer val = map.get(nums2[i]);
            if (val != null && val > 0) {
                res[index++] = nums2[i];
                map.put(nums2[i], val - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        Solution350 solution350 = new Solution350();
        solution350.intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

}
