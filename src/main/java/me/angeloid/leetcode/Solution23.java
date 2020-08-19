package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author AngeloidYun
 * @date 2020/6/8
 */
public class Solution23 {
    //堆,优先级队列
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode res = queue.poll();
        if (res != null && res.next != null) {
            queue.offer(res.next);
        }
        ListNode tail = res;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return res;
    }

    //分治法归并
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[end];
        }
        if (end == start + 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        ListNode left = merge(lists, start, (start + end) / 2);
        ListNode right = merge(lists, (start + end) / 2 + 1, end);
        return mergeTwoLists(left, right);
    }


    private ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                tail.next = nodeA;
                nodeA = nodeA.next;

            } else {
                tail.next = nodeB;
                nodeB = nodeB.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        tail.next = nodeA == null ? nodeB : nodeA;
        return res.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        Solution23 solution23 = new Solution23();
        solution23.mergeKLists(new ListNode[]{node1, node4, node7});
    }
}
