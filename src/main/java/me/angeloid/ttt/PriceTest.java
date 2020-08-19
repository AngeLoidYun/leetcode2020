package me.angeloid.ttt;

/**
 * @author AngeloidYun
 * @date 2020/6/24
 */
public class PriceTest {

    public long price(int years, long origin, float growthRate, int add) {

        for (int i = 0; i < years; i++) {
            origin = (long) (origin * growthRate) + add;
            add = (int) (add * 1.05f);
        }
        return origin;
    }

    public static void main(String[] args) {
        System.out.println(new PriceTest().price(35, 40000, 1.15f, 40000));
    }
}
