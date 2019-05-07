package com.zhaluobox.crazyjava.chapter06.section06;

public class TestInterfaceImplements {

    public static void main(String[] args) {
        Zhangsan zhangsan = new Zhangsan();
        zhangsan.eat();
        zhangsan.drink();
        zhangsan.say();
        zhangsan.experience();

        //接口类方法方法
        Person.aphorism();
        Lisi lisi = new Lisi();
        lisi.say();
        lisi.drink();
        lisi.eat();
        lisi.experience();

    }
}
