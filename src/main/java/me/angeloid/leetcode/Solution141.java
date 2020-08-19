package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020-01-06
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
        }
        return false;
    }


    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}

