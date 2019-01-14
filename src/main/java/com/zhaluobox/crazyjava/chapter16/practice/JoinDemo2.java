package com.zhaluobox.crazyjava.chapter16.practice;

/**
 * 线程让步代码演示:
 *
 * API: [3种重载的方法]
 *      Join()
 *      Join(long millis) 让步多少秒
 *      Join(long millis,int nanos): 让步多少秒+毫秒 一般不用因为普通的CPU是无法准确到毫秒的;
 */
public class JoinDemo2 {

    public static void main(String[] args) {
        Thread eat = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(i == 30){
                    /**
                     * 子线程
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
                System.out.println(Thread.currentThread().getName() + " 吃了 " + i + "分钟");
            }
        }, "张三");
        eat.start();
    }
}
