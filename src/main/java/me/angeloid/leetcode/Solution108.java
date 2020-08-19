package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/7/3
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = buildBST(nums, l, m - 1);
        node.right = buildBST(nums, m + 1, r);
        return node;
    }
}
