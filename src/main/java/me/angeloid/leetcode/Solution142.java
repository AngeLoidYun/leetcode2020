package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020/6/8
 */
public class Solution142 {
    /**
     * 哈希表法
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     *双指针法则
     * 两指针先一快一慢到达相遇点k
     * 前段为F,环为C
     * c=a+b,a先经过b后经过
     * 2(F+a) =F+n(a+b)+a
     * F+2a = n(a+b)+a
     * F = (n-1)a +nb
     * F = (n-1)C +b
     * 即前段为(n-1)圈加b
     * 故使用指针在head和相遇点步进为1即可找到起始点。
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;
        while (hare != null && hare.next != null) {
            if (tortoise == hare) {
                //step 2.
                ListNode ptr1 = head;
                ListNode ptr2 = hare;
                while (true) {
                    if (ptr1 == ptr2) {
                        return ptr1;
                    }
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return null;
    }
}
