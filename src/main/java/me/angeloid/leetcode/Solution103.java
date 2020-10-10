package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftToRight = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        lo(queue, leftToRight, res);
        return res;
    }

    private void lo(Deque<TreeNode> queue, boolean leftToRight, List<List<Integer>> res) {
        Deque<TreeNode> nextDeque = new LinkedList<>();
        List<Integer> subList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node;
            node = queue.removeFirst();
            if (node != null) {
                if (leftToRight) {
                    subList.add(node.val);

                } else {
                    subList.add(0, node.val);
                }
                nextDeque.offer(node.left);
                nextDeque.offer(node.right);
            }
        }
        if (subList.size() != 0) {
            res.add(subList);
        }
        if (nextDeque.size() != 0) {
            lo(nextDeque, !leftToRight, res);
        }
    }

    public static void main(String[] args) {
        Solution103 solution103 = new Solution103();
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(solution103.zigzagLevelOrder(node0));
    }
}
