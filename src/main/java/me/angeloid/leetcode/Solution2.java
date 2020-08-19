package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;


/**
 * @author AngeloidYun
 * @date 2020/6/7
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode curTail = listNode;
        int cf = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + cf;
            cf = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curTail.next = node;
            curTail = curTail.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //坑，最后一个进位不能忘记进
        if (cf == 1) {
            curTail.next = new ListNode(1);
        }
        return listNode.next;
    }
}
