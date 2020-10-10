package me.angeloid.test;

import java.util.concurrent.atomic.AtomicInteger;

public class CASCompareWithBase {

    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int j = 0;
            while (j < Integer.MAX_VALUE) {
                j++;
            }
        }
        System.out.println(System.currentTimeMillis() - curTime);
        curTime = System.currentTimeMillis();
        AtomicInteger ctl = new AtomicInteger(0);
        int opaque;
        for (int i = 0; i < 1; i++) {
            ctl.set(0);
            while ((opaque = ctl.get()) < Integer.MAX_VALUE) {
                ctl.compareAndSet(opaque, opaque + 1);
            }
        }
        System.out.println(System.currentTimeMillis() - curTime);


        CYC1:
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            CYC2:
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                CYC3:
                for (int k = 0; k < Integer.MAX_VALUE; k++) {
                    if (k == 100) {
                        break CYC1;
                    }
                }
            }
        }
    }


}
