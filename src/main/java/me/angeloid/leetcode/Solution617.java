package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeTrees0(t1, t2);
    }

    private TreeNode mergeTrees0(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val1 = t1 == null ? 0 : t1.val;
        int val2 = t2 == null ? 0 : t2.val;
        TreeNode res = new TreeNode(val1 + val2);
        res.left = mergeTrees0(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        res.right = mergeTrees0(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return res;
    }
}
