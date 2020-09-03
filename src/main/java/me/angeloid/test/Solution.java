package me.angeloid.test;


import sun.misc.Unsafe;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Optional;

/**
 * @author AngeloidYun
 * @date 2020/8/4
 */
public class Solution {


    private static Integer change(Integer b) {
        b += 3;
        return b;
    }

    public static String appendStr(String s) {
        s += "bbb";
        System.out.println(s);
        return s;
    }

    public static String getAddresses(Object... objects) {
        StringBuffer sb = new StringBuffer();
        sb.append("0x");
        // sun.arch.data.model=32 // 32 bit JVM
        // sun.arch.data.model=64 // 64 bit JVM
        boolean is64bit = Integer.parseInt(System.getProperty("sun.arch.data.model")) == 32 ? false : true;
        Unsafe unsafe = getUnsafe();
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                // 输出指针地址
                sb.append(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        sb.append(", +" + Long.toHexString(i2 - last));
                    else
                        sb.append(", -" + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        return sb.toString();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
