package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
