package me.angeloid.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/25
 * AOE网络排序
 */
public class AOESorting {
    static class Pair {
        public Pair(int des, int dur) {
            this.des = des;
            this.dur = dur;
        }

        int des;
        int dur;

        @Override
        public String toString() {
            return "Pair{" +
                    "des=" + des +
                    ", dur=" + dur +
                    '}';
        }
    }

    /**
     * 默认0号点是入口，n-1号点是出口
     *
     * @param graph
     * @return
     */
    public static List<List<Integer>> AOESorting(List<List<Pair>> graph) {
        final int count = graph.size();
        int[] ve = new int[count];
        int[] vl = new int[count];
        for (int i = 0; i < count; i++) {
            List<Pair> pairList = graph.get(i);
            for (Pair p : pairList
            ) {
                if (ve[i] + p.dur > ve[p.des]) {
                    ve[p.des] = ve[i] + p.dur;
                }
            }
        }
        vl[count - 1] = ve[count - 1];
        for (int i = count - 2; i > 0; i--) {
            List<Pair> pairList = graph.get(i);
            for (Pair p : pairList
            ) {
                if (vl[p.des] - p.dur > vl[i]) {
                    vl[i] = vl[p.des] - p.dur;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Pair> pairList = graph.get(i);
            for (Pair p : pairList
            ) {
                int ae = ve[i];
                int al = vl[p.des] - p.dur;
                if (ae == al) {
                    int finalI = i;
                    res.add(new ArrayList<Integer>() {{
                        add(finalI);
                        add(p.dur);
                        add(p.des);
                    }});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Pair> p0 = new ArrayList<Pair>() {{
            add(new Pair(1, 6));
            add(new Pair(2, 4));
            add(new Pair(3, 5));
        }};
        List<Pair> p1 = new ArrayList<Pair>() {{
            add(new Pair(4, 1));
        }};
        List<Pair> p2 = new ArrayList<Pair>() {{
            add(new Pair(4, 1));
        }};
        List<Pair> p3 = new ArrayList<Pair>() {{
            add(new Pair(5, 2));
        }};
        List<Pair> p4 = new ArrayList<Pair>() {{
            add(new Pair(6, 9));
            add(new Pair(7, 7));
        }};
        List<Pair> p5 = new ArrayList<Pair>() {{
            add(new Pair(7, 4));
        }};
        List<Pair> p6 = new ArrayList<Pair>() {{
            add(new Pair(8, 2));
        }};
        List<Pair> p7 = new ArrayList<Pair>() {{
            add(new Pair(8, 4));
        }};
        List<Pair> p8 = new ArrayList<>();
        List<List<Pair>> lists = new ArrayList<>();
        lists.add(p0);
        lists.add(p1);
        lists.add(p2);
        lists.add(p3);
        lists.add(p4);
        lists.add(p5);
        lists.add(p6);
        lists.add(p7);
        lists.add(p8);
        System.out.println(AOESorting(lists));
    }
}
