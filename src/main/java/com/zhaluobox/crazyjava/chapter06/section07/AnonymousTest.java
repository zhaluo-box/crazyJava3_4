package com.zhaluobox.crazyjava.chapter06.section07;


interface Product {
    public double getPrice();

    public String getName();
}

abstract class Consumer {

    abstract void shop();

    abstract void pay();

}

class Student{

    String  name;
    String  age;

    public void run(){
        System.out.println("----奔跑吧少年---");
    }
}

public class AnonymousTest {
    public void test(Product p) {
        System.out.println("购买了一个" + p.getName()
                + "，花掉了" + p.getPrice());
    }

    public void test2(Consumer c) {
        System.out.println("-----圣诞节大促销-----");
    }

    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        // 调用test()方法时，需要传入一个Product参数，
        // 此处传入其匿名实现类的实例
        ta.test(new Product() {
            public double getPrice() {
                return 567.8;
            }

            public String getName() {
                return "AGP显卡";
            }
        });

        Consumer consumer = null;
        ta.test2(consumer = new Consumer() {

            @Override
            void shop() {
                System.out.println("-------买买买---------");
            }

            @Override
            void pay() {
                System.out.println("-------钱钱钱--------");
            }
        });
        consumer.pay();
        consumer.shop();

    }
}
