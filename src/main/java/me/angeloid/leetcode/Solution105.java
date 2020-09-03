package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AngeloidYun
 * @date 2020-01-08
 */
public class Solution105 {

    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length);
    }

    public TreeNode build(int inStart, int inEnd) {
        if (inStart == inEnd) {
            return null;
        }
        //当前的根元素根节点
        TreeNode node = new TreeNode(preorder[preIndex]);
        //遍历start，end，找到这个元素的位置
        int mid = map.get(preorder[preIndex]);
        //找到之后，
        preIndex++;
        node.left = build(inStart, mid);
        node.right = build(mid + 1, inEnd);
        return node;
    }

    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        solution105.buildTree(new int[]{1, 2}, new int[]{1, 2});
    }
}
