package me.angeloid.leetcode.source;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/12
 */
// Definition for a Node.
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
