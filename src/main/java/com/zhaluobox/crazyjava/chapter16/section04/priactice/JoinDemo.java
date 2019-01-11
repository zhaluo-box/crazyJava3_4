package com.zhaluobox.crazyjava.chapter16.section04.priactice;

public class JoinDemo {

    /**
     * 主线程
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 子线程1
         */
        Thread eat = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃了 " + i + "分钟");
            }
        }, "张三");
        eat.start();

        for (int i = 0; i < 100 ; i++) {
            if(i == 30){

                /**
                 * 子线程2
                 */
                Thread drink = new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(Thread.currentThread().getName() + " 喝了 " + j + "毫升豆奶");
                    }
                }, "张三");
                drink.start();
                try {
                    drink.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + i );
        }
    }
}
