package me.angeloid.test;

/**
 * @author AngeloidYun
 * @date 2020/8/25
 */
public class JVMInitOrder {
    static int a = 10;
    int b = 5;


    public static void main(String[] args) {
//        JVMInitOrder st = new JVMInitOrder();
        staticFunction();
    }

    static JVMInitOrder st = new JVMInitOrder();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }





    public static int value = 123;

    JVMInitOrder() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }
}
