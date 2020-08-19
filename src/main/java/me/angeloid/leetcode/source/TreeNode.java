package me.angeloid.leetcode.source;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author AngeloidYun
 * @date 2020-01-02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        TreeNode res = new TreeNode(arr[0]);
        TreeNode cur = res;
        int curProcess = 0;
        for (int i = 1; i < arr.length; i++) {

            if (curProcess == 0) {
                cur.left = arr[i] == null ? null : new TreeNode(arr[i]);
            }
            if (curProcess == 1) {
                cur.right = arr[i] == null ? null : new TreeNode(arr[i]);
                cur = list.removeFirst();
                curProcess = 0;
            }
            curProcess++;
        }
        return res;
    }
}


