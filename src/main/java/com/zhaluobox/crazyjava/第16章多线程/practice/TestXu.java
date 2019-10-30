package com.zhaluobox.crazyjava.第16章多线程.practice;

/**
 * 测试多线程同步代码块
 *
 *   假设旭旭宝宝和韩茜茜新年发红包
 *   共计200个
 *   每个50元
 *   支付宝余有9000元差点钱
 */
public class TestXu {

    public static void main(String[] args) {
        AccountXu xu = new AccountXu("旭旭宝宝", 8000d);
        ThreadXu threadXu = new ThreadXu(xu, 50d,200,0);
        Thread t1 = new Thread(threadXu,"旭旭宝宝");
        Thread t2 = new Thread(threadXu,"韩茜茜");
        t1.start();
        t2.start();
    }
}
