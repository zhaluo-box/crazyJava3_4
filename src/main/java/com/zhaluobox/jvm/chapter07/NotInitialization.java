package com.zhaluobox.jvm.chapter07;

/**
 * 除了5种 不会触发类的初始化,称为被动引用
 *
 * 虚拟机参数:
 * -XX:+TraceClassLoading
 */
public class NotInitialization {

    public static void main(String[] args) {

        // 在初始化的时候, 只有直接定义value这个字段的类才会初始化 所以父类会初始化 子类不会初始化
        System.out.println(ChildClass.value);
        System.out.println(ChildClass.HAN_ZI_VALUE);
        /*
        结果:
            父类 初始化 init
            123
         */
    }
}
