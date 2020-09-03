package me.angeloid.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/8/27
 */


public class ObjectWaitTest {

    public static void main(String[] args) {

        Pool pool = new Pool();

        Productor p1 = new Productor("生產者", pool);

        Productor p2 = new Productor("生產者", pool);

        Customer c1 = new Customer("消費者", pool);

        p1.start();

        p2.start();

        c1.start();

    }

}


//生产者

class Productor extends Thread {

    static volatile int i = 0;

    private String name;

    private Pool pool;


    public Productor(String name, Pool pool) {

        this.name = name;

        this.pool = pool;

    }


    public void run() {

        while (true) {
            synchronized (Productor.class){
                i=i+1;
                pool.add(i);
                System.out.println("生产了" + i + "");
            }
            try {
                Thread.sleep(500);

            } catch (Exception e) {

                e.printStackTrace();

            }



        }


    }

}


//消费者

class Customer extends Thread {

    private String name;

    private Pool pool;


    public Customer(String name, Pool pool) {

        this.name = name;

        this.pool = pool;

    }


    public void run() {

        while (true) {

            int i = pool.remove();
            System.out.println("消费了" + i);
            try {

                Thread.sleep(1000);

            } catch (Exception e) {

                e.printStackTrace();

            }


        }

    }

}


//生产 删除方法类

class Pool {

    private List<Integer> list = new ArrayList<Integer>();

    //容量最大值

    private int Max = 100;//防止栈溢出，到达100等待


    //添加元素

    public void add(int n) {

        synchronized (this) {

            try {

                while (list.size() >= Max) {

                    this.wait();

                }

                list.add(n);

                System.out.println("size ==" + list.size());

                this.notify();


            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }


    //刪除元素

    public int remove() {

        synchronized (this) {

            try {

                while (list.size() == 0) {

                    this.wait();

                }

                int i = list.remove(0);

                this.notify();

                return i;


            } catch (Exception e) {

                e.printStackTrace();

            }

            return -1;

        }

    }


}