package com.zhaluobox.juc.chapter16.chapter16_04_控制线程;


/**
 *
 */
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

        for (int i = 0; i < 1000; i++) {
            // 主线程跑到20的时候需要 线程2 启动
            if (i == 20) {
                th2.start();
            }
            System.out.println( Thread.currentThread().getName() + " : " + i );
        }
        try {
            th1.join();
            th2.join();
            System.out.println("-----------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

