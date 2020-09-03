package me.angeloid.test;

import java.util.concurrent.*;

/**
 * @author AngeloidYun
 * @date 2020/8/28
 */
public class ThreadPoolTest {
    static class MyRunnable implements Delayed {


        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

    static class MyRunnable2 extends MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }

    private static DelayQueue<MyRunnable2> delayQueue = new DelayQueue<>();
    private static ThreadPoolExecutor threadPool;

    public static void main(String[] args) {
//        threadPool = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, delayQueue);
    }
}
