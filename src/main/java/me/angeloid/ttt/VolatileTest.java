package me.angeloid.ttt;

/**
 * @author AngeloidYun
 * @date 2020/6/23
 */
public class VolatileTest implements Runnable {

    private int count = 0;

    private void add() {
        for (int i = 0; i < 1000; i++) {
            count++;
            System.out.println("count = " + count);
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        add();
    }


    public static void main(String[] args) {
//            VolatileTest demo = new VolatileTest();
//            Thread t1 = new Thread(demo);
//            Thread t2 = new Thread(demo);
//            Thread t3 = new Thread(demo);
//
//            t1.start();
//            t2.start();
//            t3.start();

        TestRunnable runnable = new TestRunnable();
        new Thread(runnable).start();
        while (true) {
            if (runnable.isFlag()) {
                try {
                    Thread.sleep(100);
                    System.out.println("我是true啦");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class TestRunnable implements Runnable {
          boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public boolean isFlag() {
            return flag;
        }
    }

}
