package me.angeloid.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author AngeloidYun
 * @date 2020/5/25
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> slideWindow = new HashSet<>();
        char[] array = s.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while (j < array.length) {
            while (slideWindow.contains(array[j])) {
                slideWindow.remove(array[i]);
                i++;
            }
            slideWindow.add(array[j]);
            max = Math.max(max, slideWindow.size());
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("sdfqrtqbtkjqhgfsybcvajfqtbttttbbtmqhewmadhgff"));
    }
}
