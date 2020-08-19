package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/6/1
 */
public class Solution695 {
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] flag = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area = 0;
                if (grid[i][j] == 1 && flag[i][j] == 0) {
                    //new island.
                    flag[i][j] = 1;
                    find(grid, flag, i, j);
                }
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private void find(int[][] grid, int[][] flag, int i, int j) {
        flag[i][j] = 1;
        if (grid[i][j] == 1) {
            area++;
        }
        if (grid[i][j] == 0) {
            return;
        }
        //up
        if (j - 1 >= 0 && flag[i][j - 1] == 0) {
            find(grid, flag, i, j - 1);
        }
        //down
        if (j + 1 < grid[0].length && flag[i][j + 1] == 0) {
            find(grid, flag, i, j + 1);
        }
        if (i - 1 >= 0 && flag[i - 1][j] == 0) {
            find(grid, flag, i - 1, j);
        }
        if (i + 1 < grid.length && flag[i + 1][j] == 0) {
            find(grid, flag, i + 1, j);
        }
    }

    public static void main(String[] args) {

    }
}
