package com.zhaluobox.crazyjava.chapter16.practice.section02;

/**
 * 线程创建的方式2
 *        1. 实现Runnable
 *        2. 重写run方法
 *        3. 创建实例
 *        4. 将实例作为参数传递给new Thread(Runnable runnable, String name)
 *        5. start 启动
 *
 */
public class ThreadCreateMethodSecond implements Runnable {

    int i =100;
    Object obj = new Object();

    @Override
    public void run() {
        while (i > 0) {
            synchronized (obj) {
                try {
                    i--;
                    System.out.println(Thread.currentThread().getName() + (i > 0 ? (": 余票    " + i + "    张") : (": 已售完")));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final ThreadCreateMethodSecond th1 = new ThreadCreateMethodSecond();
        new Thread(th1,"窗口1").start();
        new Thread(th1,"窗口2").start();
    }
}
