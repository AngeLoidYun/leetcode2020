package me.angeloid.leetcode;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author AngeloidYun
 * @date 2020/6/1
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - k];
    }


    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length - k + 1, (o1, o2) -> o2-o1);
        for (int num : nums
        ) {
            priorityQueue.offer(num);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        solution215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
