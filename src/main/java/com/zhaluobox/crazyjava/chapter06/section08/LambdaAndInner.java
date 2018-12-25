package com.zhaluobox.crazyjava.chapter06.section08;

import java.sql.SQLOutput;

/**
 * Lambda 与  匿名内部类区别
 * 1.lambda 表达式是匿名内部类的一种简化，可以部分取代内部类的作用
 * 2.表达式与匿名内部类一样，都可以直接方法 effectively final的局部变量，及外部类的成员变量(包括实例变量和类变量)
 * 3.lambda表达式创建的对象与匿名内部类生成的对象一样，都可以直接调用从接口中继承的默认方法
 */

@FunctionalInterface
interface Displayable {
    //定义一个抽象方法和默认方法
    void display();

    default int addable(int a, int b) {
        return a + b;
    }
}


public class LambdaAndInner {

    //外部类的实例变量及类变量
    private int age = 12;
    private static String name = "疯狂软件教育中心";

    public void test() {
        String book = "疯狂Java讲义";   //局部内部类方法了该方法，隐含的final
        Displayable dis = () -> {
            //访问 effectively final 的局部变量
            System.out.println("book局部变量为： " + book);
            //访问外部类的实例变量和类变量
            System.out.println("外部类的age实例变量： " + age);
            System.out.println("外部类的name实例变量： " + name);

            // lamdba 代码块不允许调用默认方法
            // System.out.println(addable(2,3));

            //不允许
//            @Override
//            public int addable(int a, int b) {
//                return 0;
//            }
        };

        dis.display();

        //调用dis对象从接口继承的add()默认方法
        dis.addable(4, 5);

        Displayable dd = new Displayable() {

            @Override
            public void display() {
                System.out.println(addable(2, 3));
            }


//            @Override
//            public int addable(int a, int b) {
//                return 0;
//            }
        };
    }


    public static void main(String[] args) {
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
    }

}






























