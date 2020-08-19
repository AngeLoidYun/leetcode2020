package me.angeloid.leetcode;

import me.angeloid.leetcode.source.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author AngeloidYun
 * @date 2020/6/16
 */
public class Solution297 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> lineQueue = new LinkedList<>();
            if (root != null) {
                queue.offer(root);
                boolean canContinue = true;
                while (canContinue) {
                    canContinue = false;
                    while (!queue.isEmpty()) {
                        lineQueue.offer(queue.poll());
                    }
                    while (!lineQueue.isEmpty()) {
                        TreeNode node = lineQueue.poll();
                        builder.append(node == null ? "null" : node.val);
                        builder.append(',');
                        if (node == null) {
                            queue.offer(null);
                            queue.offer(null);
                        } else {
                            if (node.left != null) {
                                canContinue = true;
                                queue.offer(node.left);
                            } else {
                                queue.offer(null);
                            }
                            if (node.right != null) {
                                canContinue = true;
                                queue.offer(node.right);
                            } else {
                                queue.offer(null);
                            }
                        }
                    }
                }
            }
            int cIndex;
            if ((cIndex = builder.lastIndexOf(",")) != -1) {
                builder.deleteCharAt(cIndex);
            }
            builder.append("]");
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            StringBuilder builder = new StringBuilder(data);
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
            String[] array = builder.toString().split(",");
            if (array.length > 0 && !"null".equals(array[0]) && array[0].length() > 0) {
                TreeNode root = new TreeNode(Integer.parseInt(array[0]));
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                int i = 1;
                while (i < array.length) {
                    TreeNode lNode, rNode;
                    if (!"null".equals(array[i])) {
                        int lVal = Integer.parseInt(array[i]);
                        lNode = new TreeNode(lVal);
                    } else {
                        lNode = null;
                    }
                    i++;
                    if (!"null".equals(array[i])) {
                        int rVal = Integer.parseInt(array[i]);
                        rNode = new TreeNode(rVal);
                    } else {
                        rNode = null;
                    }
                    TreeNode parent = queue.poll();
                    queue.offer(lNode);
                    queue.offer(rNode);
                    if (parent != null) {
                        parent.left = lNode;
                        parent.right = rNode;
                    }
                    i++;
                }
                return root;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Codec codeC = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        String s = codeC.serialize(null);
        System.out.println(s);
        TreeNode treeNode = codeC.deserialize(s);
    }


}
