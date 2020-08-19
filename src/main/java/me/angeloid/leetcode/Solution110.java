package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/8/17
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = dfs(root.left, 0);
        int right = dfs(root.right, 0);
        if (left == -1 || right == -1) {
            return false;
        }
        return Math.abs(left - right) <= 1;
    }

    private int dfs(TreeNode node, int curLength) {
        if (node == null || curLength == -1) {
            return curLength;
        }
        curLength = curLength + 1;
        int left = dfs(node.left, curLength);
        int right = dfs(node.right, curLength);
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}
