package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/7/7
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum, 0);
    }

    private boolean dfs(TreeNode root, int sum, int curSum) {
        curSum = root.val + curSum;
        if (root.left == null && root.right == null) {
            return curSum == sum;
        }
        boolean res = false;
        if (root.left != null)
            res = dfs(root.left, sum, curSum);
        if (root.right != null)
            res |= dfs(root.right, sum, curSum);
        return res;
    }
}
