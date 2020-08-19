package me.angeloid.ttt;

import java.util.*;

/**
 * @author AngeloidYun
 * @date 2020/6/9
 */
public class SolutionFindMax1000 {
    public List<Integer> findMax(int count, int k) {
        List<Integer> max1000 = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        List<Integer> data = new ArrayList<>();
        //random
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            data.add(random.nextInt());
        }
        long time = System.currentTimeMillis();
        System.out.println("startTime:" + time);
        for (int i = 0; i < data.size(); i++) {
            int value = data.get(i);
            if (queue.size() < k) {
                queue.offer(value);
            } else if (queue.peek() != null && queue.peek() < value) {
                queue.poll();
                queue.add(value);
            }
        }
        for (int i = 0; i < k; i++) {
            max1000.add(queue.poll());
        }
        System.out.println("cost:" + (System.currentTimeMillis() - time));
        return max1000;
    }


    public List<Integer> findMin(int count, int k) {
        List<Integer> max1000 = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> data = new ArrayList<>();
        //random
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            data.add(Math.abs(random.nextInt()));
        }
        long time = System.currentTimeMillis();
        System.out.println("startTime:" + time);
        for (int i = 0; i < data.size(); i++) {
            int value = data.get(i);
            if (queue.size() < k) {
                queue.offer(value);
            } else if (queue.peek() != null && queue.peek() > value) {
                queue.poll();
                queue.add(value);
            }
        }
        for (int i = 0; i < k; i++) {
            max1000.add(queue.poll());
        }
        System.out.println("cost:" + (System.currentTimeMillis() - time));
        System.out.println("MIN" + data.stream().min(Comparator.comparingInt(o -> o)));
        return max1000;
    }

    public static void main(String[] args) {
        SolutionFindMax1000 solutionFindMax1000 = new SolutionFindMax1000();
        System.out.println(solutionFindMax1000.findMin(50000000, 1000));
    }


}
