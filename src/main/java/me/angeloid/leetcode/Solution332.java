package me.angeloid.leetcode;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author AngeloidYun
 * @date 2020/8/27
 */
public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        //出发站，List<到达站>
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> list :
                tickets) {
            map.compute(list.get(0), (s, innerList) -> {
                if (innerList == null) {
                    innerList = new ArrayList<>();
                }
                innerList.add(list.get(1));
                innerList.sort(String::compareTo);
                return innerList;
            });
        }
        return dfs(map, List.of("JFK"), "JFK", tickets.size());
    }

    private List<String> dfs(Map<String, List<String>> map, List<String> res, String current, int leftCount) {
        List<String> toList = map.get(current);
        if (leftCount == 0 && (toList == null || toList.size() == 0)) {
            return res;
        }

        for (String target : toList
        ) {
            Map<String, List<String>> copyMap = new HashMap<>();
            for (Map.Entry<String, List<String>> mapEntry : map.entrySet()
            ) {
                List<String> newList = new ArrayList<>(mapEntry.getValue());
                if (current.equals(mapEntry.getKey())) {
                    newList.remove(target);
                }
                copyMap.put(mapEntry.getKey(), newList);
            }
            List<String> newRes = new ArrayList<>(res);
            newRes.add(target);
            List<String> readyResult = dfs(copyMap, newRes, target, leftCount - 1);
            if (readyResult != null) {
                return readyResult;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution332 solution332 = new Solution332();
        List<String> res = solution332.findItinerary(List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"),
                List.of("ATL", "SFO")));
        System.out.println(res);
    }
}
