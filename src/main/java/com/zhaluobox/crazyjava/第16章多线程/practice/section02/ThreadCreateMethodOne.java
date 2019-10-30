package com.zhaluobox.crazyjava.第16章多线程.practice.section02;

/**
 * 多线程创建的方式1
 * 1. 创建Thread的子类
 * 2. 重写run方法 [业务执行体-逻辑主要存在的地方]
 * 3. 创建子类的示例.start启动
 */
public class ThreadCreateMethodOne extends Thread {

    /**
     * 继承Thread方式定义的线程,要将变量定义成static 类变量资源才能被共享
     */
    public static int i = 100;
    public static Object obj = new Object();

    @Override
    public void run() {
        while (i > 0) {
            synchronized (obj) {
                try {
                    i--;
                    System.out.println(this.getName() + (i > 0 ? (": 余票    " + i + "    张") : (": 已售完")));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
