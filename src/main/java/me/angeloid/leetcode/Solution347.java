package me.angeloid.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author AngeloidYun
 * @date 2020/9/7
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Pair, Integer> map = new TreeMap<>();
        for (int v : nums
        ) {
            Integer value = map.get(new Pair(v, 0));
            if (value != null) {
                map.put(new Pair(v, 0), value + 1);
            } else {
                map.put(new Pair(v, 0), 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        public Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }

        int number;
        int count;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return this.count - o.count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            return number == pair.number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        System.out.print(Arrays.toString(solution347.topKFrequent(new int[]{1, 1, 2, 2, 2, 3, 3, 3}, 2)));
    }
}
