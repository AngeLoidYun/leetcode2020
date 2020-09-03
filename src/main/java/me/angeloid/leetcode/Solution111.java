package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/8/21
 */
public class Solution111 {
    private int maxDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            maxDepth = Math.min(maxDepth, depth);
        } else {
            depth++;
            if (root.left != null) {
                dfs(root.left, depth);
            }
            if (root.right != null) {
                dfs(root.right, depth);
            }
        }
    }
}
