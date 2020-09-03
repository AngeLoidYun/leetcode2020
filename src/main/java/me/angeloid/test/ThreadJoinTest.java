package me.angeloid.test;

/**
 * @author AngeloidYun
 * @date 2020/8/27
 */
public class ThreadJoinTest extends Thread {

    int i;
    Thread previousThread; //上一个线程

    public ThreadJoinTest(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
//            try {
//                //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
//                previousThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        System.out.println("num:" + i);
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1" + previousThread.getState());
                synchronized (previousThread) {
                    System.out.println("1。1" + previousThread.getState());
                    previousThread.notify();
                    System.out.println("1。2" + previousThread.getState());
                }
                System.out.println("2" + previousThread.getState());
            }
        }).start();
        try {
            synchronized (previousThread) {
                System.out.println("4。1" + previousThread.getState());
                previousThread.wait();

                System.out.println("4" + previousThread.getState());
            }
            System.out.println("3" + previousThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("aaa");
//            for(int i=0;i<10;i++){
//                ThreadJoinTest joinDemo=new ThreadJoinTest(previousThread,i);
//                joinDemo.start();
//                previousThread=joinDemo;
//            }
    }
}
