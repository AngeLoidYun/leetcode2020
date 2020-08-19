package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

/**
 * @author AngeloidYun
 * @date 2020/6/7
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode resHead = new ListNode(-1);
        ListNode curEnd = resHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curEnd.next = l1;
                l1 = l1.next;
            } else {
                curEnd.next = l2;
                l2 = l2.next;
            }
            curEnd = curEnd.next;
        }
        curEnd.next = l1 == null ? l2 : l1;
        return resHead.next;
    }
}
