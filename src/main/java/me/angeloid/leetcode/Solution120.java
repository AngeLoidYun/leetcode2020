package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/6/8
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            List<Integer> dpLine = new ArrayList<>();
            dp.add(dpLine);
            for (int j = 0; j < line.size(); j++) {
                if (i == 0) {
                    dpLine.add(line.get(0));
                } else {
                    if (j == 0) {
                        dpLine.add(j, dp.get(i - 1).get(0) + line.get(0));
                    } else if (j == line.size() - 1) {
                        dpLine.add(j, dp.get(i - 1).get(line.size() - 2) + line.get(line.size() - 1));
                    } else {
                        dpLine.add(j, Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + line.get(j));
                    }

                }
                if (i == triangle.size() - 1) {
                    min = Math.min(min, dpLine.get(j));
                }
            }
        }
        return min;
    }
}
