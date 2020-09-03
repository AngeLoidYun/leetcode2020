package me.angeloid.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/25
 * 拓扑排序
 */
public class TopologicalSorting {


    /**
     * 方案1 统计入度数量
     *
     * @param lists
     * @return
     */
    public static List<Integer> topologicalSorting(List<List<Integer>> lists) {
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[lists.size()];
        boolean[] visited = new boolean[lists.size()];
        int count = lists.size();
        for (List<Integer> list : lists
        ) {
            for (int v : list
            ) {
                inDegree[v] += 1;
            }
        }
        while (count > 0) {
            for (int i = 0; i < lists.size(); i++) {
                if (inDegree[i] == 0 && !visited[i]) {//有可以删除的节点
                    visited[i] = true;
                    res.add(i);
                    count--;
                    for (int v : lists.get(i)
                    ) {
                        inDegree[v] -= 1;
                    }
                }
            }
        }
        if (count == 0) {
            return res;
        }
        throw new RuntimeException("存在环");
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list0 = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(5);
        }};
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(7);
        }};
        List<Integer> list3 = new ArrayList<Integer>() {{
            add(6);
        }};
        List<Integer> list4 = new ArrayList<Integer>() {{
        }};
        List<Integer> list5 = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(7);
        }};
        List<Integer> list6 = new ArrayList<Integer>() {{

        }};
        List<Integer> list7 = new ArrayList<Integer>() {{
            add(3);
        }};
        List<Integer> list8 = new ArrayList<Integer>() {{
            add(3);
        }};
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        lists.add(list6);
        lists.add(list7);
        lists.add(list8);

        System.out.println(topologicalSorting(lists));
    }
}
