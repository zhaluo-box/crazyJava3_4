package com.zhaluobox.crazyjava.第16章多线程.chapter16_04_控制线程;

public class JoinTest {


    public static void main(String[] args) {
        Runnable thread1 = () -> {
            for (int i = 0; i < 30; i++) {
                System.out.println( Thread.currentThread().getName() + " : " + i );
            }
        };

        final Thread th1 = new Thread( thread1, "线程1" );
        final Thread th2 = new Thread( thread1, "线程2" );
        th1.start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                th2.start();
            }
            System.out.println( Thread.currentThread().getName() + " : " + i );
        }
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

