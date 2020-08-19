package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class Solution543 {
    /**
     * 左子树高度+右子树高度+1
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfTree(root);
        return max;
    }

    int max = 0;

    private int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = heightOfTree(root.left);
        int rightTreeHeight = heightOfTree(root.right);
        max = Math.max(leftTreeHeight + rightTreeHeight, max);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}

