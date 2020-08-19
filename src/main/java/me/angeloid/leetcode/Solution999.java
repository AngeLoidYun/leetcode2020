package me.angeloid.leetcode;

import javafx.util.Pair;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class Solution999 {
    public int numRookCaptures(char[][] board) {
        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, -1, 1};
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            char[] inside = board[i];
            for (int j = 0; j < inside.length; j++) {
                if (inside[j] == 'R') {
                    for (int k = 0; k < 4; k++) {
                        int x = i;
                        int y = j;
                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                                break;
                            }
                            if (board[x][y] == 'p') {
                                res++;
                                break;
                            }
                        }
                    }
                    return res;
                }
            }
        }
        return -1;
    }


}
