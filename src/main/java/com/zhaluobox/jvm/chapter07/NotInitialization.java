package com.zhaluobox.jvm.chapter07;

/**
 * 除了5种 不会触发类的初始化,称为被动引用
 *
 * 虚拟机参数:
 * -XX:+TraceClassLoading
 */
public class NotInitialization {

    public static void main(String[] args) {

        System.out.println(ChildClass.value);
        /*
        结果:
            父类 初始化 init
            2
         */

//        SuperClass[] ss = new SuperClass[10];

    }
}
