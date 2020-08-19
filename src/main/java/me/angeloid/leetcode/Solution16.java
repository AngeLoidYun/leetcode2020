package me.angeloid.leetcode;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.tools.javadoc.Start;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020/6/24
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            //间隔，表示和距离target的远近，如果变得更远了，取消
            int interval = Math.abs(nums[i] + nums[j] + nums[k] - target);
            int pres = res;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) <= interval) {

                } else {
                    break;
                }
                pres = getAdjacent(sum, res, target);
                if (sum > target) {
                    while (k > 0 && nums[k - 1] == nums[k]) k--;
                    k--;
                } else {
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                    j++;
                }
                res = pres;
            }


        }
        return res;
    }


    private int getAdjacent(int a, int b, int target) {
        if (Math.abs((long) a - target) > Math.abs((long) b - target)) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }
}
