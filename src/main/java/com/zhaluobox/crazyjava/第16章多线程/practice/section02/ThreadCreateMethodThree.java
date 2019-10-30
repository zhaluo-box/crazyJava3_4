package com.zhaluobox.crazyjava.第16章多线程.practice.section02;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCreateMethodThree implements Callable<Integer> {

    int i =100;
    Object obj = new Object();

    @Override
    public Integer call()  {
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
        return i;
    }

    public static void main(String[] args) {
        final FutureTask<Integer> task = new FutureTask<>(new ThreadCreateMethodThree());
        new Thread(task,"线程1").start();
        new Thread(task,"线程2").start();
    }
}
