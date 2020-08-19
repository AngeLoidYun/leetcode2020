package me.angeloid.ttt;

/**
 * @author AngeloidYun
 * @date 2020/7/8
 */
public class EchoSelector {
    public static void main(String[] args) {
        String cn = System.getProperty("java.nio.channels.spi.SelectorProvider");
        System.out.println(cn);
    }
}
