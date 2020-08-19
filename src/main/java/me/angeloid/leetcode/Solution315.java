package me.angeloid.leetcode;

import java.util.*;

/**
 * @author AngeloidYun
 * @date 2020/7/11
 */
public class Solution315 {
    /**
     * 暴力法
     * (超时)
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int p = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    p++;
            }
            list.add(p);
        }
        return list;
    }


    private int[] c;
    private int[] a;

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    public static void main(String[] args) {
        Solution315 solution315 = new Solution315();
        int pos = 10000;
        while (pos > 0) {
            pos -= solution315.lowBit(pos);
            System.out.println(pos);
        }
    }


}
