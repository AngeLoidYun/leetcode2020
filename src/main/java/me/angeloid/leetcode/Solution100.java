package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

/**
 * @author AngeloidYun
 * @date 2020/8/7
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}
