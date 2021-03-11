package com.zhaluobox.juc.chapter16.practice;


/**
 * 同步代码块测试
 */
public class TestXu2 {

    public static void main(String[] args) {
        AccountXu xu = new AccountXu("旭旭宝宝", 100000d);
        ThreadXu2 threadXu = new ThreadXu2(xu, 50d,200,0);
        Thread t1 = new Thread(threadXu,"旭旭宝宝");
        Thread t2 = new Thread(threadXu,"韩茜茜");
        t1.start();
        t2.start();
    }
}
