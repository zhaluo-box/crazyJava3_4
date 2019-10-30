package com.zhaluobox.crazyjava.第18章类加载机制与反射.section05.DynaProxy;


public class DogUtil {
    // 第一个拦截器方法
    public void method1() {
        System.out.println("=====模拟第一个通用方法=====");
    }

    // 第二个拦截器方法
    public void method2() {
        System.out.println("=====模拟通用方法二=====");
    }
}
