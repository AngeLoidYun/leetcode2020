package me.angeloid.leetcode;

import me.angeloid.test.Solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution117 {

    static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        Node left;
        Node right;
        Node next;
    }


    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        resolve(queue);
        return root;
    }

    private void resolve(Deque<Node> queue) {
        if (!queue.isEmpty()) {
            Deque<Node> nextStack = new LinkedList<>();
            Node pre = null;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                nextStack.offer(node.left);
                nextStack.offer(node.right);
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = pre.next;
                }
            }
            resolve(nextStack);
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        Solution117 solution117 = new Solution117();
        solution117.connect(node1);
    }


}
