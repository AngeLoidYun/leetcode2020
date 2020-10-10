package me.angeloid.leetcode;

import me.angeloid.leetcode.source.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int v = 0;
        for (int i = 1; i <= n; i++) {
            v = 0;
            if (i % 3 == 0) {
                v = 1;
            }
            if (i % 5 == 0) {
                v = v == 1 ? 3 : 2;
            }
            switch (v) {
                case 1:
                    res.add("Fizz");
                    break;
                case 2:
                    res.add("Buzz");
                    break;
                case 3:
                    res.add("FizzBuzz");
                    break;
                default:
                    res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
