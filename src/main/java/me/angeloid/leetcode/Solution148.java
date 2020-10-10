package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode len = head;
        while (len != null) {
            length++;
            len = len.next;
        }
        ListNode vNode = new ListNode(-1);
        vNode.next = head;

        for (int i = 1; i < length; i *= 2) {
            ListNode pre = vNode;
            ListNode cur = vNode.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = split(cur, i);
                cur = split(h2, i);
                ListNode temp = merge(h1, h2);
                pre.next = temp;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return vNode.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }
        ListNode res = head;
        for (int i = 1; i < step && res.next != null; i++) {
            res = res.next;
        }
        ListNode right = res.next;
        res.next = null;
        return right;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode vNode = new ListNode(-1);
        ListNode temp = vNode;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        temp.next = h1 == null ? h2 : h1;
        return vNode.next;
    }
}
