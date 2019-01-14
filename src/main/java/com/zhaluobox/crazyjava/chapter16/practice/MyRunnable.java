package com.zhaluobox.crazyjava.chapter16.practice;

/**
 * 多线程实现方式2
 * 注意:
 *      在这里获取线程的名称不能再是this.getName(),而是Thread.currentThread().getName();
 *      这里获取当前线程要使用Thread 的静态方式 currentThread() 方法;
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<100; i++ ){
            System.out.println(Thread.currentThread().getName()+ " - " + i);
        }
    }
}
