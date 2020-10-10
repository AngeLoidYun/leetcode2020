package me.angeloid.leetcode;

public class Solution79 {
    int[] dir_x = new int[]{0, 0, 1, -1};
    int[] dir_y = new int[]{1, -1, 0, 0};
    int M;
    int N;

    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;
        boolean[][] used = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, word, 1, j, i, used)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int nextIndex, int cur_x, int cur_y, boolean[][] used) {
        if (nextIndex == word.length()) {
            return true;
        }
        used[cur_y][cur_x] = true;//use it.
        char select = word.charAt(nextIndex);
        //find select.
        for (int i = 0; i < 4; i++) {
            int nextX = cur_x + dir_x[i];
            int nextY = cur_y + dir_y[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (board[nextY][nextX] == select && !used[nextY][nextX]) {
                    if (find(board, word, nextIndex + 1, nextX, nextY, used)) {
                        return true;
                    }
                }
            }
        }
        used[cur_y][cur_x] = false;
        return false;
    }
}
