package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author AngeloidYun
 * @date 2020/5/27
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> c1Map = new HashMap<>();
        Map<Character, Integer> c2Map = new HashMap<>();
        for (char c : s1.toCharArray()
        ) {
            c1Map.compute(c, (character, integer) -> {
                if (integer == null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            });
        }
        //init c2map
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            c2Map.compute(c, (character, integer) -> {
                if (integer == null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            });
        }
        int i = 0;
        do {
            boolean allTrue = true;
            for (Map.Entry<Character, Integer> entry : c1Map.entrySet()
            ) {
                if (entry.getValue().equals(c2Map.get(entry.getKey()))) {
                } else {
                    allTrue = false;
                }
            }
            if (allTrue) {
                return true;
            }
            c2Map.put(s2.charAt(i), c2Map.get(s2.charAt(i)) - 1);
            if (i + s1.length() < s2.length()) {
                c2Map.compute(s2.charAt(i + s1.length()), (character, integer) -> {
                    if (integer == null) {
                        return 1;
                    } else {
                        return integer + 1;
                    }
                });
            }
            i++;
        } while (i + s1.length() <= s2.length());
        return false;
    }


    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> c1Map = new HashMap<>();
        for (char c : s1.toCharArray()
        ) {
            c1Map.compute(c, (character, integer) -> {
                if (integer == null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            });
        }
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            arr2[c - 97] = arr2[c - 97] + 1;
        }
        int i = 0;
        do {
            boolean allTrue = true;
            for (Map.Entry<Character, Integer> entry : c1Map.entrySet()
            ) {
                if (entry.getValue().equals(arr2[entry.getKey() - 97])) {
                } else {
                    allTrue = false;
                }
            }
            if (allTrue) {
                return true;
            }
            int del = s2.charAt(i) - 97;
            arr2[del] = arr2[del] - 1;
            if (i + s1.length() < s2.length()) {
                int add = s2.charAt(i + s1.length()) - 97;
                arr2[add] = arr2[add] + 1;
            }
            i++;
        } while (i + s1.length() <= s2.length());
        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] a1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a1[s2.charAt(i) - 'a']--;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (isZero(a1)) return true;
            a1[s2.charAt(i - s1.length()) - 'a']++;
            a1[s2.charAt(i) - 'a']--;
        }
        return isZero(a1);

    }

    private boolean isZero(int[] a1) {
        return Arrays.stream(a1).allMatch(v -> v == 0);
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        System.out.println(solution567.checkInclusion3("ab", "cbdsdacvadbss"));
    }
}
