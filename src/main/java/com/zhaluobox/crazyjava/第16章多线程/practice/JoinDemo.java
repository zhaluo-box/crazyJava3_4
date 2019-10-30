package com.zhaluobox.crazyjava.第16章多线程.practice;

public class JoinDemo {

    /**
     * 主线程
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread.currentThread().setName("聊天");
        /**
         * 子线程1
         */
        Thread eat = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i + "分钟");
            }
        }, "吃");
        eat.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i + "分钟");
            if (i == 30) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
                /**
                 * 子线程2
                 */
                Thread drink = new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(Thread.currentThread().getName() + " " + j + "毫升豆奶");
                    }
                }, "喝");
                drink.start();
                try {
                    drink.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
