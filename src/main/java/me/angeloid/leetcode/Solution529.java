package me.angeloid.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author AngeloidYun
 * @date 2020/8/20
 */
public class Solution529 {
    /**
     * 扫雷
     *
     * @param board
     * @param click
     * @return
     */
    int[] dir_x = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dir_y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {

        int m = click[0];
        int n = click[1];
        if (board[m][n] == 'M') {
            board[m][n] = 'X';
        } else if (board[m][n] == 'E') {
            dfs(board, m, n);
        }
        return board;
    }

    private void dfs(char[][] board, int m, int n) {
        int bomb = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = m + dir_x[i];
            int ty = n + dir_y[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            // 不用判断 M，因为如果有 M 的话游戏已经结束了
            if (board[tx][ty] == 'M') {
                ++bomb;
            }
        }
        if (bomb > 0) {
            board[m][n] = (char) (bomb + '0');
        } else {
            board[m][n] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = m + dir_x[i];
                int ty = n + dir_y[i];
                // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    public static void main(String[] args) {
        Solution529 solution529 = new Solution529();
        char[][] arr = new char[][]{{
                'B', '1', 'E', '1', 'B'
        },
                {
                        'B', '1', 'M', '1', 'B'
                },
                {'B', '1', '1', '1', 'B'
                },

                {'B', 'B', 'B', 'B', 'B'
                }};
        solution529.updateBoard(arr, new int[]{1, 2});
        char[][] arr2 = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        solution529.updateBoard(arr2, new int[]{3, 0});
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr2));
    }


}
