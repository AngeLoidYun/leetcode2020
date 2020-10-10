package me.angeloid.test;

import java.util.Collections;
import java.util.HashMap;

public class SingletonDemo {

    public SingletonDemo() {
    }

    private volatile static SingletonDemo INSTANCE;


    /**
     * 双重检验锁+volatile。
     * 第一个if，是为了增加效率，不需要每次获取实例的时候都进入同步块。
     *
     * 第二个if，是了防止代码执行到{@code synchronized (SingletonDemo.class)}之前，进行线程切换，
     * 第二个方法又执行了，进行了一次实例初始化，后续切换会第一个线程进入同步块后，进行二次初始化的操作。
     *
     * volatile是为了防止指令进行重排序，
     * 新建对象时，会有：
     * 挑选内存地址
     * 初始化内容
     * 将内容指向内存地址
     * 如果2，3两步互相交换，那么可能获取到的INSTANCE仍然是一个空值。
     * @return
     */
    public static SingletonDemo getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDemo();
                }
            }
        }
        return INSTANCE;
    }

}
