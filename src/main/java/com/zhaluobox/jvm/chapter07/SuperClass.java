package com.zhaluobox.jvm.chapter07;

public class SuperClass {

    static {
        System.out.println("父类 初始化 init");
    }

    public SuperClass(){
        System.out.println("SuperClass空构造");
    }
    public static int value = 2;
}
