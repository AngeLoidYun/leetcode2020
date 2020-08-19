package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author AngeloidYun
 * @date 2020/6/25
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        int i = 0;
        while (i < s.length()) {
            for (String word : wordDict
            ) {
                if (i + word.length() <= s.length()) {
                    if (s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
            do {
                i++;
            } while (i < s.length() && !dp[i]);
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        System.out.println(solution139.wordBreak("aaaaaaa", new ArrayList<String>() {{
            add("aaaa");
            add("aaaa");
        }}));
    }
}
