package com.zhaluobox.crazyjava.第16章多线程.practice.section02;

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
        new Thread(th1).start();
        new Thread(th1).start();
    }
}
