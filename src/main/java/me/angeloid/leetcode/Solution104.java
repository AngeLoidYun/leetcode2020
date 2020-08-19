package me.angeloid.leetcode;

import javafx.util.Pair;
import me.angeloid.leetcode.source.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AngeloidYun
 * @date 2020-01-07
 */
public class Solution104 {
    int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth = depth + 1;
        max = Math.max(max, depth);
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public int maxDepth2(TreeNode root) {
        int maxDepth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        if (root != null) {
            queue.offer(new Pair<TreeNode, Integer>(root, 1));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            int curDepth = current.getValue();
            if (root != null) {
                maxDepth = Math.max(maxDepth, curDepth);
                queue.offer(new Pair<TreeNode, Integer>(root.left, curDepth + 1));
                queue.offer(new Pair<TreeNode, Integer>(root.right, curDepth + 1));
            }
        }
        return maxDepth;
    }


}
