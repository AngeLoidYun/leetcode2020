package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AngeloidYun
 * @date 2020/6/9
 */
public class Solution146 {
    static class LRUCache {
        int maxSize;
        int curSize = 0;
        ListNode head = new ListNode(-1);
        Map<Integer, Integer> map = new HashMap<>();

        public LRUCache(int capacity) {
            maxSize = capacity;
        }

        public int get(int key) {
            Integer value = map.get(key);
            if (value != null) {
                moveToFirst(key);
            }
            return value == null ? -1 : value;
        }

        public void put(int key, int value) {
            if (map.put(key, value) != null) {
                //找到提到最前面
                moveToFirst(key);
            } else {
                if (curSize == maxSize) {
                    ListNode curHead = head;
                    while (curHead.next != null) {
                        if (curHead.next.next == null) {
                            map.remove(curHead.next.val);
                            curHead.next = null;
                            curSize--;
                            break;
                        }
                        curHead = curHead.next;
                    }
                }
                //挂到最前面
                ListNode node = new ListNode(key);
                node.next = head.next;
                head.next = node;
                curSize++;
            }
        }

        private void moveToFirst(int key) {
            //找到提到最前面
            ListNode curHead = head.next;
            ListNode pre = head;
            while (curHead != null) {
                if (curHead.val == key) {
                    pre.next = curHead.next;
                    curHead.next = head.next;
                    head.next = curHead;
                    return;
                }
                pre = pre.next;
                curHead = curHead.next;
            }
        }


        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            cache.get(1);       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            cache.get(2);       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            cache.get(1);       // 返回 -1 (未找到)
            cache.get(3);       // 返回  3
            cache.get(4);       // 返回  4

        }
    }
}