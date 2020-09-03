package me.angeloid.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author AngeloidYun
 * @date 2020/9/3
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        //这个表示每一个皇后在第几列
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        //列号
        Set<Integer> columnSet = new HashSet<>();
        //左斜线
        Set<Integer> leftSlash = new HashSet<>();
        //右斜线
        Set<Integer> rightSlash = new HashSet<>();
        List<List<String>> list = new ArrayList<>();
        findSolution(queues, columnSet, leftSlash, rightSlash, 0, n, list);
        return list;
    }

    private void findSolution(int[] queues, Set<Integer> columnSet, Set<Integer> leftSlash, Set<Integer> rightSlash, int row, int n, List<List<String>> list) {
        if (row == n) {
            //输出
            printOut(queues, list);
            return;
        }
        //列循环
        for (int column = 0; column < n; column++) {
            if (columnSet.contains(column)) {
                continue;
            }
            int leftV = column + row;
            if (leftSlash.contains(leftV)) {
                continue;
            }
            int rightV = column - row;
            if (rightSlash.contains(rightV)) {
                continue;
            }
            queues[row] = column;
            columnSet.add(column);
            leftSlash.add(leftV);
            rightSlash.add(rightV);
            findSolution(queues, columnSet, leftSlash, rightSlash, row + 1, n, list);
            queues[row] = -1;
            columnSet.remove(column);
            leftSlash.remove(leftV);
            rightSlash.remove(rightV);
        }
    }

    private void printOut(int[] queues, List<List<String>> list) {
        List<String> inner = new ArrayList<>();
        for (int v : queues
        ) {
            char[] chars = new char[queues.length];
            Arrays.fill(chars, '.');
            chars[v] = 'Q';
            inner.add(new String(chars));
        }
        list.add(inner);
    }
}
