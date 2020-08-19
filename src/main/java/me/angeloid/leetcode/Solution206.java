package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

/**
 * @author AngeloidYun
 * @date 2020/6/7
 */
public class Solution206 {
    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode second = head.next;
        head.next = null;
        return reverse(head, second);
    }

    private ListNode reverse(ListNode head, ListNode cur) {
        if (cur == null) {
            return head;
        }
        ListNode nextCur = cur.next;
        cur.next = head;
        return reverse(cur, nextCur);
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }
        return newHead.next;
    }

}
