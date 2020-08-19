package me.angeloid.ttt;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author AngeloidYun
 * @date 2020/7/7
 */
public class CompletableFutureTest {


    public static void main(String[] args) {


        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup groupSub = new ThreadGroup(group1, "subGroup1");

        Thread thread = new Thread(group1, new Runnable() {
            @Override
            public void run() {
                ExecutorService service = Executors.newFixedThreadPool(2, r -> {
                    System.out.println("设置一个新Thread");
                    Thread thread = new Thread(groupSub, r);
                    thread.setDaemon(true);
                    return thread;
                });
                CompletableFuture<Integer> future1 = CompletableFuture
                        .supplyAsync(() -> {
                            try {
                                Thread.sleep(6000);
                                System.out.println(Thread.currentThread() + "future1");
                                return (int) (Math.random() * 100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }, service);

                CompletableFuture<Integer> future2 = CompletableFuture
                        .supplyAsync(() ->
                        {
                            try {
                                Thread.sleep(4000);

                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(Thread.currentThread() + "future2");
                            throw new RuntimeException("eee");
                        }, service);

        /*
        测试Either 特性
         */

                CompletableFuture<String> finalFuture = future1.applyToEitherAsync(future2, new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {

                        return Thread.currentThread() + String.valueOf(integer);
                    }
                }, service).exceptionally(new Function<Throwable, String>() {
                    @Override
                    public String apply(Throwable throwable) {
                        throwable.printStackTrace(System.out);
                        return Thread.currentThread() + throwable.toString();
                    }
                }).whenCompleteAsync(new BiConsumer<String, Throwable>() {
                    @Override
                    public void accept(String s, Throwable throwable) {
                        System.out.println(Thread.currentThread() + "whenComplete" + s);
                    }
                }, service);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String s = finalFuture.join();
                System.out.println("new Thread 结束了" + s);

            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("start了");
        try {
            Thread.sleep(10000);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
