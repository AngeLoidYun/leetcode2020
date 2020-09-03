package me.angeloid.leetcode;

import me.angeloid.ttt.Solution1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author AngeloidYun
 * @date 2020/8/26
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[][] chars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'},
                {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> res = new ArrayList<>();
        add(chars, res, new StringBuilder(), digits, 0);
        return res;
    }

    private void add(char[][] chars, List<String> res, StringBuilder builder, String digits, int index) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char[] arr = chars[digits.charAt(index) - '2'];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder subBuilder = new StringBuilder(builder);
            subBuilder.append(arr[i]);
            add(chars, res, subBuilder, digits, index + 1);
        }

    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }
}
