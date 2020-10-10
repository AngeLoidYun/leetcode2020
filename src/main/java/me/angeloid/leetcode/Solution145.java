package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        backTraversal(list, root);
        return list;
    }

    private void backTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        backTraversal(list, root.left);
        backTraversal(list, root.right);
        list.add(root.val);
    }
}
