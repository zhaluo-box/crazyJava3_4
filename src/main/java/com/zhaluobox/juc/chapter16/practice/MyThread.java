package com.zhaluobox.juc.chapter16.practice;

/**
 * 多线程的实现方式1
 *
 * this  即可获取当前线程
 * this.getName() 方法即可获取当前线程名称
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i=0; i<100; i++ ){
            System.out.println(this.getName()+ " - " + i);
        }
    }
}
