package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;
import me.angeloid.leetcode.source.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author AngeloidYun
 * @date 2020/8/18
 */
public class Solution109 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public TreeNode sortedListToBST(ListNode head) {
        Map<TreeNode, Integer> bfMap = new HashMap<>();
        TreeNode treeNode = null;
        while (head != null) {
            treeNode = insertAVL(treeNode, head.val, bfMap);
            head = head.next;
        }
        return treeNode;
    }

    private TreeNode insertAVL(TreeNode root, int val, Map<TreeNode, Integer> bfMap) {
        Stack<TreeNode> stack = new Stack<>();//记录路径，方便找到平衡因子并旋转
        int d;
        TreeNode p = root;
        TreeNode pr = null;
        while (p != null) {
            if (val == p.val) return root;
            pr = p;
            stack.push(pr);
            if (val < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        p = new TreeNode(val);
        bfMap.put(p, 0);
        if (pr == null) {//这里上面的while循环不会走
            root = p;
            return root;
        }
        if (val < pr.val) {
            pr.left = p;
        } else {
            pr.right = p;
        }
        while (!stack.isEmpty()) {
            pr = stack.pop();
            if (p == pr.left) {
                bfMap.put(pr, bfMap.get(pr) - 1);
            } else {
                bfMap.put(pr, bfMap.get(pr) + 1);
            }
            int prBf = bfMap.get(pr);
            if (prBf == 0) {
                break;
            }
            if (prBf == 1 || prBf == -1) {
                p = pr;
            } else {
                d = prBf < 0 ? -1 : 1;
                if (bfMap.get(p) == d) {
                    if (d == -1) {
                        pr = RotateR(pr, bfMap);
                    } else {
                        pr = RotateL(pr, bfMap);
                    }
                } else {
                    if (d == -1) {
                        pr = RotateLR(pr, bfMap);
                    } else {
                        pr = RotateRL(pr, bfMap);
                    }
                }
                break;
            }
        }
        if (stack.isEmpty()) {
            root = pr;
        } else {
            TreeNode q = stack.peek();
            if (q.val > pr.val) {
                q.left = pr;
            } else {
                q.right = pr;
            }
        }
        return root;
    }

    private TreeNode RotateRL(TreeNode pr, Map<TreeNode, Integer> bfMap) {
        TreeNode subL = pr;
        TreeNode subR = subL.right;
        pr = subL.left;
        subR.left = pr.right;
        pr.right = subR;
        if (bfMap.get(pr) >= 0) {
            bfMap.put(subR, 0);
        } else {
            bfMap.put(subR, 1);
        }
        subL.right = pr.left;
        pr.left = subL;
        if (bfMap.get(pr) == 1) {
            bfMap.put(subL, -1);
        } else {
            bfMap.put(subL, 0);
        }
        bfMap.put(pr, 0);
        return pr;
    }

    private TreeNode RotateLR(TreeNode pr, Map<TreeNode, Integer> bfMap) {
        TreeNode subR = pr;
        TreeNode subL = subR.left;
        pr = subL.right;
        subL.right = pr.left;
        pr.left = subL;
        if (bfMap.get(pr) <= 0) {
            bfMap.put(subL, 0);
        } else {
            bfMap.put(subL, -1);
        }
        subR.left = pr.right;
        pr.right = subR;
        if (bfMap.get(pr) == -1) {
            bfMap.put(subR, 1);
        } else {
            bfMap.put(subR, 0);
        }
        bfMap.put(pr, 0);
        return pr;

    }

    private TreeNode RotateL(TreeNode pr, Map<TreeNode, Integer> bfMap) {
        TreeNode node = pr;
        pr = pr.right;
        node.right = pr.left;
        pr.left = node;
        bfMap.put(pr, 0);
        bfMap.put(node, 0);
        return pr;
    }

    private TreeNode RotateR(TreeNode pr, Map<TreeNode, Integer> bfMap) {
        TreeNode node = pr;
        pr = pr.left;
        node.left = pr.right;
        pr.right = node;
        bfMap.put(pr, 0);
        bfMap.put(node, 0);
        return pr;
    }


    public TreeNode sortedListToBST2(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode median = getMedian(head, tail);
        TreeNode treeNode = new TreeNode(median.val);
        treeNode.left = buildTree(head, median);
        treeNode.right = buildTree(median.next, tail);
        return treeNode;
    }

    private ListNode getMedian(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution109.sortedListToBST(node1);
    }
}

