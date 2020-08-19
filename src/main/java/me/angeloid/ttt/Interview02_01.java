package me.angeloid.ttt;

import me.angeloid.leetcode.source.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020/6/27
 */
public class Interview02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode aHead = new ListNode(-1);
        aHead.next = head;
        ListNode pre = aHead;
        aHead = aHead.next;
        while (aHead != null) {
            if (set.contains(aHead.val)) {
            } else {
                set.add(aHead.val);
                pre = pre.next;
            }
            aHead = aHead.next;
            pre.next = aHead;
        }
        return head;
    }


    public static void main(String[] args) {
//        Interview02_01 interview02_01 = new Interview02_01();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(2);
//        ListNode node6 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        interview02_01.removeDuplicateNodes(node1);
        System.out.println(0xffffffff - 0xc0000000);
    }
}
