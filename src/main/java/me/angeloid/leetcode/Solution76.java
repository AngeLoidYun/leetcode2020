package me.angeloid.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author AngeloidYun
 * @date 2020/6/9
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        String minChar = null;
        for (char c : t.toCharArray()
        ) {
            need.compute(c, (character, integer) -> {
                if (integer == null) {
                    return 1;
                }
                return ++integer;
            });
        }
        Map<Character, Integer> have = new HashMap<>();
        int start = 0;
        int end = 0;
        while (start < s.length()) {
            boolean checked = check(have, need);
            if (end < s.length() && (have.size() < need.size() || !checked)) {
                char c = s.charAt(end);
                if (need.get(c) != null) {
                    have.compute(c, (character, integer) -> {
                        if (integer == null) {
                            return 1;
                        }
                        return ++integer;
                    });
                }
                end++;
            } else if (start <= end) {
                if (checked) {
                    if (minChar == null) {
                        minChar = s.substring(start, end);
                    } else if (minChar.length() > end - start) {
                        minChar = s.substring(start, end);
                    }
                }
                char c = s.charAt(start);
                if (need.get(c) != null) {
                    have.compute(c, (character, integer) -> {
                        if (integer == null) {
                            return 1;
                        }
                        return --integer;
                    });
                }
                start++;
            }
        }
        return minChar==null?"":minChar;
    }

    private boolean check(Map<Character, Integer> have, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            Integer haveCount = have.get(entry.getKey());
            if (haveCount == null || haveCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow("ADOBECODEBANC", "ABC"));

    }
}
