package me.angeloid.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author AngeloidYun
 * @date 2020/7/2
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[i * matrix.length + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }


    public static void main(String[] args) {
        Solution378 solution378 = new Solution378();
//        solution378.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        solution378.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2);
    }
}
